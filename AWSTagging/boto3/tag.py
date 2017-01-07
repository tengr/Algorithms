import boto3
from os.path import expanduser
#ec2 = boto3.resource('ec2')

import xlsxwriter

import string

output_dir = expanduser("~") + "/STG/"

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
        files = ["Environment", "Backup", "Application", "Name"]
        name = next((tag["Value"] for tag in ins.tags if tag["Key"] == "Name"), None)
        name_cnt += next((1 for tag in ins.tags if tag["Key"] == "Name"), 0)
        for f in files:
            if all(tag["Key"] != f for tag in ins.tags):
                    write(f, name, ins) 
                              
print "in total " + str(ins_cnt) + " instance"
print "in total " + str(missing_cnt) + " missing"
print name_cnt
for workbook in workbooks:
    workbook.close()

# ret = ec2.describe_instances(Filters = filters)
# for i in ret:
#     print i