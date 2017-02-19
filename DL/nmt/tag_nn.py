from geniatagger import GeniaTagger
import codecs
import sys
tagger = GeniaTagger('/Users/ruichen/DL/geniatagger-3.0.2/geniatagger')


read_dir = '/Users/ruichen/DL/bio_de_mt/pubmed_en_fr_separate/'

en_fn = read_dir + 'pubmed_en.txt'
fr_fn = read_dir + 'pubmed_fr.txt'

# UTF8Writer = codecs.getwriter('utf8')
# sys.stdout = UTF8Writer(sys.stdout)


def decode_list(l):
    return [ tuple(word.decode('utf-8') for word in tp)  for tp in l]

#sys.stdout = codecs.getwriter('utf8')(sys.stdout)

def tag():

    out_fn = "test.txt"
    #out_fn = "genia_raw_tag_pubmed_en_fr.txt" 
    out_file = codecs.open(out_fn, encoding='utf-8', mode='w+')
    
    with codecs.open(en_fn, encoding='utf-8') as ef:
        with codecs.open(fr_fn, encoding = 'utf-8') as ff: 
            for en, fr in zip(ef, ff):
    #             parse_result = tagger.parse(line.encode('utf-8'))
    #             print parse_result
    #             print type(parse_result[0])
    #             break
    #print type (tagger.parse(en.encode('utf-8'))[-1][0]), tagger.parse(fr.encode('utf-8')[-1][0])
                decode_fr = decode_list(tagger.parse(fr.encode('utf-8')))
                #print decode_fr
                #print decode_fr
                for tp in decode_fr:
                    for word in tp:
                        out_file.write(word + "\t")
                break
        
with open('genia_raw_tag_pubmed_en_fr.txt', 'r') as f:
    