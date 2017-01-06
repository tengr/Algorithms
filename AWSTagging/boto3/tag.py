import boto3
#ec2 = boto3.resource('ec2')

import xlsxwriter

import string

output_dir = "/Users/ruichen/STG/"

ec2 = boto3.resource("ec2")
# filters = [{'Name':'tag:Name', 'Values':['svc-active-directory-management']}]
#list1 = list(ec2.instances.filter(Filters=filters))[0]
missing_cnt = 0
ins_cnt = 0
name_cnt = 0

#id, instance id, name, instance type, vpc id

files = ["Environment", "Backup", "Application", "Name"]
fields = ["id", "instance id", "name", "instance type", "vpc id","missing tag"]
#fields_col = ["A","B","C","D","E","F"]
fields_col = string.uppercase[:len(fields)]
ws_dict = {}
workbooks = []
row_num_dict = {}

for f in files:
    workbook = xlsxwriter.Workbook(output_dir + f + '_missing.xlsx')
    workbooks.append(workbook)
    worksheet = workbook.add_worksheet()
    for idx, field in enumerate(fields):
        if field != "missing tag":
            worksheet.write(fields_col[idx]+"1", field)
        else:
            worksheet.write(fields_col[idx]+"1", field + " : " + f)

    ws_dict[f] = worksheet
    row_num_dict[f] = 2

def write(filename, name, ins):
    ws = ws_dict[filename]
    #fields = ["id", "instance id", "name", "instance type", "vpc id"]
    for idx, field in enumerate(fields):
        if field == "id":
            ws.write(fields_col[idx]+str(row_num_dict[filename]), ins.id)
        elif field == "instance id":
            ws.write(fields_col[idx]+str(row_num_dict[filename]), ins.instance_id)
        elif field == "name":
            ws.write(fields_col[idx]+str(row_num_dict[filename]), name)
        elif field == "instance type":
            ws.write(fields_col[idx]+str(row_num_dict[filename]), ins.instance_type)                
        elif field == "vpc id":
            ws.write(fields_col[idx]+str(row_num_dict[filename]), ins.vpc_id)
        else:
            ws.write(fields_col[idx]+str(row_num_dict[filename]), None)
        
    row_num_dict[filename] += 1

ids = []    
name_cnt = 0
for ins in ec2.instances.all():
    # tag only running
    #ins.create_tags(Tags=[{'Key': 'Owner','Value': 'SportsTG'}])
    if(ins.state['Name'] != 'running'):
        continue
    else:
        ins_cnt += 1
        if ins.id:
            ids.append(ins.id)
        env_found = False
        backup_found = False
        app_found = False
        name_found = False
        avail_found = False
        owner_found = False
        name = None
        for tag in ins.tags:
            #id, name, instance type, vpc id
            if tag["Key"] == "Environment": #
                env_found = True
            elif tag["Key"] == "Backup": #
                backup_found = True
            elif tag["Key"] == "Application": #
                app_found = True
            elif tag["Key"] == "Name": #
                name = tag["Value"]
                name_found = True
            elif tag["Key"] == "Availability":
                avail_found = True
            elif tag["Key"] == "Owner":
                #SportsTG
                owner_found = True
        if not env_found:
            filename = "Environment"
            write(filename, name, ins)
        if not backup_found:
            filename = "Backup"
            write(filename, name, ins)
        if not app_found:
            filename = "Application"
            write(filename, name, ins)
        if not name_found:
            name_cnt += 1
            filename = "Name"
            print ins.instance_id + "\t" + ins.instance_type + "\t" + str(ins.vpc)
            write(filename, name, ins)
        if not avail_found:
            pass
        if not owner_found:
            pass
          
            #print "availability not tagged for instance " + ins.id
 
            
#print "avail cnt = " + str(avail_cnt)            
print "in total " + str(ins_cnt) + " instance"
print "in total " + str(missing_cnt) + " missing"
print name_cnt
for workbook in workbooks:
    workbook.close()

# ret = ec2.describe_instances(Filters = filters)
# for i in ret:
#     print i