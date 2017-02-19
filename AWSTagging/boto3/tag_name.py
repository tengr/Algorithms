import boto3
ec2 = boto3.resource("ec2")

TAG = 'Name'

def gen_tags():
    pass

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

show_tags()
#check_missing_tags()