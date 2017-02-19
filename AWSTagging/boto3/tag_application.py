from os.path import expanduser
from xlrd import open_workbook
import boto3
ec2 = boto3.resource("ec2")
TAG = 'Application'

def gen_tags():
    read_dir = expanduser("~") + "/STG/"
    wb = open_workbook(read_dir + "Application Tagging (1).xlsx")
    #sheet_names = wb.sheet_names()

    tag_dict = {}

    for idx, sheet in enumerate(wb.sheets()):
        if idx == 1 or idx == 3:
            continue
        tag = None
        if idx == 0:
            tag = "Application"
        else:
            tag = "Environment"
        number_of_rows = sheet.nrows
        #number_of_columns = sheet.ncols
        for row in range(1, number_of_rows):
            ins_id  = sheet.cell(row, 1).value
            tag_val = sheet.cell(row, 5).value
            if tag_val is not None and len(tag_val) > 0:    
                #print tag + "\t" + ins_id + "\t" + tag_val
                if not tag_dict.has_key(ins_id):
                    tag_dict[ins_id] = {}
                tag_dict[ins_id][tag] = tag_val
                
                
    for ins in ec2.instances.all():
        if tag_dict.has_key(ins.id):
            for tg, tg_val in tag_dict[ins.id].iteritems():
                #print tg + "\t" + ins.id + "\t" + tg_val   
                ins.create_tags(Tags=[{'Key': tg,'Value': tg_val}])


def show_tags():    
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue 
        for tag in ins.tags:
            if tag['Key'] == TAG:
                print ins.id + "\t" + tag['Value']

def check_missing_tags():  
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue  
        if all(tag["Key"] != TAG for tag in ins.tags):
            print ins.id
#show_tags()
check_missing_tags()            
            
            
            
                
