from bs4 import BeautifulSoup
import re
from collections import Counter
from bs4.element import Comment
import urllib.request
import json
import sys


def tag_visible(element):
    if element.parent.name in ['style', 'script', 'head', 'title', 'meta', '[document]']:
        return False
    if isinstance(element, Comment):
        return False
    return True


def text_from_html(body):
    soup = BeautifulSoup(body, 'html.parser')
    texts = soup.findAll(text=True)
    #visible_texts = filter(tag_visible, texts)  
    return u" ".join(t.strip() for t in texts)

html = urllib.request.urlopen(''.join(sys.argv[1:])).read()
visible_text_string=text_from_html(html)
lst=re.findall(r'\b\w+', visible_text_string)
lst = [x.lower() for x in lst]
counter = Counter(lst)
occs = [(count-1,word) for word,count in counter.items() if count > 5]
occs.sort(key=lambda x:x[1],reverse=True)
list0=[]
cont=0
#list2=[]
#for f in occs:
#    tupl=("word",f[0])
#    list0.append(tupl)
#    tupl2=("count",f[1])
    #list2=[tupl,tupl2]
#    list0.append(tupl2)
#    cont=cont+1
    #print(tupl)
    #print(tupl2)
rs = json.dumps(dict(occs))
print(rs)
