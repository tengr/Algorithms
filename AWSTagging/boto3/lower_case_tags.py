import boto3
ec2 = boto3.resource("ec2")
tgs = ["Environment", "Backup", "Application", "Name"]

def lower_case_all_tags():    
    for ins in ec2.instances.all():
        if(ins.state['Name'] != 'running'):
            continue
        for tag in ins.tags:
            if tag['Key'] in tgs and tag['Value']:
                ins.create_tags(Tags=[{'Key': tag['Key'],'Value': tag['Value'].lower()}])

lower_case_all_tags()