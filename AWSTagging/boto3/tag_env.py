import boto3
ec2 = boto3.resource("ec2")

TAG = 'Environment'

def gen_tags():

    for ins in ec2.instances.all():
        for tag in ins.tags:
            if tag['Key'] != TAG:
                continue
            tag_val = tag['Value']
            if tag_val == '1d1w':
                #print ins.id + "\t" + tag_val
                ins.create_tags(Tags=[{'Key': TAG,'Value': 'production'}])
            else:
                ins.create_tags(Tags=[{'Key': TAG,'Value': tag_val.lower()}])
            
            #print tag['Value']

def show_tags():    
    for ins in ec2.instances.all():
        for tag in ins.tags:
            if tag['Key'] == TAG:
                print ins.id + "\t" + tag['Value']

def check_missing_tags():  
    for ins in ec2.instances.all():  
        if(ins.state['Name'] != 'running'):
            continue 
        if all(tag["Key"] != TAG for tag in ins.tags):
            print ins.id


#check_missing_tags()
#show_tags()