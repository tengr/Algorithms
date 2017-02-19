import boto3
ec2 = boto3.resource("ec2")

TAG = 'Backup'

def gen_tags():
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue  
        if all(tag["Key"] != TAG for tag in ins.tags):
            ins.create_tags(Tags=[{'Key': 'Backup','Value': '1d1w'}])


def show_tags():    
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue
        for tag in ins.tags:
            if tag['Key'] == TAG:
                #print ins.security_groups
                print ins.id + "\t" + str(ins.security_groups) + "\t"+ tag['Value']

# def get_group_info(ins):
#     s = ""
#     for gp in ins.security_groups:
#         s += str(''.join(gp))
#     return s

def check_missing_tags():  
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue  
        if all(tag["Key"] != TAG for tag in ins.tags):
            print ins.id


#check_missing_tags()
show_tags()