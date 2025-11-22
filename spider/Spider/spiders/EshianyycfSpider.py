# # -*- coding: utf-8 -*-

# 数据爬取文件

import scrapy
import pymysql
import pymssql
from ..items import EshianyycfItem
import time
from datetime import datetime,timedelta
import datetime as formattime
import re
import random
import platform
import json
import os
import urllib
from urllib.parse import urlparse
import requests
import emoji
import numpy as np
from DrissionPage import Chromium
import pandas as pd
from sqlalchemy import create_engine
from selenium.webdriver import ChromeOptions, ActionChains
from scrapy.http import TextResponse
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import pandas as pd
from sqlalchemy import create_engine
from selenium.webdriver import ChromeOptions, ActionChains
from scrapy.http import TextResponse
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.chrome.service import Service
# 营养成份
class EshianyycfSpider(scrapy.Spider):
    name = 'eshianyycfSpider'
    custom_settings = {
        'HTTPERROR_ALLOWED_CODES': [400,403],
        'RETRY_HTTP_CODES': [500, 503]
    }
    spiderUrl = 'https://www.eshian.com/sat/yyss/list'
    start_urls = spiderUrl.split(";")
    protocol = ''
    hostname = ''
    realtime = False


    def __init__(self,realtime=False,*args, **kwargs):
        super().__init__(*args, **kwargs)
        self.realtime = realtime=='true'


    # 列表解析
    def parse(self, response):
        _url = urlparse(self.spiderUrl)
        self.protocol = _url.scheme
        self.hostname = _url.netloc
        plat = platform.system().lower()
        if not self.realtime and (plat == 'linux' or plat == 'windows'):
            connect = self.db_connect()
            cursor = connect.cursor()
            if self.table_exists(cursor, 'b205u294_eshianyycf') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return
        list = response.xpath('''//table/tbody/tr''')
        for item in list:
            fields = EshianyycfItem()

            try:
                fields["cname"] = str( item.xpath('''.//td[1]/a/text()''').extract_first())

            except:
                pass
            try:
                fields["xqurl"] = str("https://www.eshian.com" + item.xpath('''.//a/@href''').extract_first())

            except:
                pass
            detailUrlRule = item.xpath('''a::attr(href)''').extract_first()
            detailUrlRule ="https://www.eshian.com" + detailUrlRule 
            if self.protocol in detailUrlRule or detailUrlRule.startswith('http'):
                pass
            elif detailUrlRule.startswith('//'):
                detailUrlRule = self.protocol + ':' + detailUrlRule
            elif detailUrlRule.startswith('/'):
                detailUrlRule = self.protocol + '://' + self.hostname + detailUrlRule
            else:
                detailUrlRule = self.protocol + '://' + self.hostname + '/' + detailUrlRule
            yield scrapy.Request(url=detailUrlRule, meta={'fields': fields},  callback=self.detail_parse, dont_filter=True)

    # 详情解析
    def detail_parse(self, response):
        fields = response.meta['fields']
        try:
            fields["ename"] = str( response.xpath('''//tbody/tr[1]/td[2]/text()''').extract()[0].strip())

        except:
            pass
        try:
            fields["spfenlei"] = str( response.xpath('''//tbody/tr[2]/td[1]/text()''').extract()[0].strip())

        except:
            pass
        try:
            fields["keshibu"] = float( response.xpath('''//tbody/tr[2]/td[2]/text()''').extract()[0].strip().replace('%',''))
        except:
            pass
        try:
            fields["laiyuan"] = str( response.xpath('''//tbody/tr[3]/td[1]/text()''').extract()[0].strip())

        except:
            pass
        try:
            fields["chandi"] = str( response.xpath('''//tbody/tr[3]/td[2]/text()''').extract()[0].strip())

        except:
            pass
        try:
            fields["nengliang"] = float( response.xpath('''//tbody/tr[5]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["danbaizhi"] = float( response.xpath('''//tbody/tr[5]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["zhifang"] = float( response.xpath('''//tbody/tr[6]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["baohezhifang"] = float( response.xpath('''//tbody/tr[6]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["fanshizfs"] = float( response.xpath('''//tbody/tr[7]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["dbbhzfs"] = float( response.xpath('''//tbody/tr[7]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["duobbhzfs"] = float( response.xpath('''//tbody/tr[8]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["dangc"] = float( response.xpath('''//tbody/tr[8]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["tshhw"] = float( response.xpath('''//tbody/tr[9]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["tang"] = float( response.xpath('''//tbody/tr[9]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["rutang"] = float( response.xpath('''//tbody/tr[10]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["sanshiqw"] = float( response.xpath('''//tbody/tr[10]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["kesxssqw"] = float( response.xpath('''//tbody/tr[11]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["bsxssqw"] = float( response.xpath('''//tbody/tr[11]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshuna"] = float( response.xpath('''//tbody/tr[12]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshua"] = float( response.xpath('''//tbody/tr[12]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshud"] = float( response.xpath('''//tbody/tr[13]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshue"] = float( response.xpath('''//tbody/tr[13]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshuk"] = float( response.xpath('''//tbody/tr[14]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshub1"] = float( response.xpath('''//tbody/tr[14]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshub2"] = float( response.xpath('''//tbody/tr[15]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshub6"] = float( response.xpath('''//tbody/tr[15]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshub12"] = float( response.xpath('''//tbody/tr[16]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["weishengshuc"] = float( response.xpath('''//tbody/tr[16]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["yanshuan"] = float( response.xpath('''//tbody/tr[17]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["yeshuan"] = float( response.xpath('''//tbody/tr[17]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["fanshuan"] = float( response.xpath('''//tbody/tr[18]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["shenwushu"] = float( response.xpath('''//tbody/tr[18]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["danjian"] = float( response.xpath('''//tbody/tr[19]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshulin"] = float( response.xpath('''//tbody/tr[19]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshujia"] = float( response.xpath('''//tbody/tr[20]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshumei"] = float( response.xpath('''//tbody/tr[20]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshugai"] = float( response.xpath('''//tbody/tr[21]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshutie"] = float( response.xpath('''//tbody/tr[21]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshuxin"] = float( response.xpath('''//tbody/tr[22]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshudian"] = float( response.xpath('''//tbody/tr[22]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshudxi"] = float( response.xpath('''//tbody/tr[23]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshutong"] = float( response.xpath('''//tbody/tr[23]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshufu"] = float( response.xpath('''//tbody/tr[24]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["jinshumeng"] = float( response.xpath('''//tbody/tr[24]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["deltae"] = float( response.xpath('''//tbody/tr[25]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["beitae"] = float( response.xpath('''//tbody/tr[25]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["aerfae"] = float( response.xpath('''//tbody/tr[26]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["hulubo"] = float( response.xpath('''//tbody/tr[26]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["zhifansz"] = float( response.xpath('''//tbody/tr[27]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["huifen"] = float( response.xpath('''//tbody/tr[27]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["shuifen"] = float( response.xpath('''//tbody/tr[28]/td[1]/text()''').extract()[0].strip())
        except:
            pass
        try:
            fields["nengliangqk"] = float( response.xpath('''//tbody/tr[28]/td[2]/text()''').extract()[0].strip())
        except:
            pass
        return fields

    # 数据清洗
    def pandas_filter(self):
        engine = create_engine('mysql+pymysql://root:123456@localhost/spiderb205u294?charset=UTF8MB4')
        df = pd.read_sql('select * from eshianyycf limit 50', con = engine)

        # 重复数据过滤
        df.duplicated()
        df.drop_duplicates()

        #空数据过滤
        df.isnull()
        df.dropna()

        # 填充空数据
        df.fillna(value = '暂无')

        # 异常值过滤

        # 滤出 大于800 和 小于 100 的
        a = np.random.randint(0, 1000, size = 200)
        cond = (a<=800) & (a>=100)
        a[cond]

        # 过滤正态分布的异常值
        b = np.random.randn(100000)
        # 3σ过滤异常值，σ即是标准差
        cond = np.abs(b) > 3 * 1
        b[cond]

        # 正态分布数据
        df2 = pd.DataFrame(data = np.random.randn(10000,3))
        # 3σ过滤异常值，σ即是标准差
        cond = (df2 > 3*df2.std()).any(axis = 1)
        # 不满⾜条件的⾏索引
        index = df2[cond].index
        # 根据⾏索引，进⾏数据删除
        df2.drop(labels=index,axis = 0)

    # 去除多余html标签
    def remove_html(self, html):
        if html == None:
            return ''
        pattern = re.compile(r'<[^>]+>', re.S)
        return pattern.sub('', html).strip()

    # 数据库连接
    def db_connect(self):
        type = self.settings.get('TYPE', 'mysql')
        host = self.settings.get('HOST', 'localhost')
        port = int(self.settings.get('PORT', 3306))
        user = self.settings.get('USER', 'root')
        password = self.settings.get('PASSWORD', '123456')

        try:
            database = self.databaseName
        except:
            database = self.settings.get('DATABASE', '')

        if type == 'mysql':
            connect = pymysql.connect(host=host, port=port, db=database, user=user, passwd=password, charset='utf8mb4')
        else:
            connect = pymssql.connect(host=host, user=user, password=password, database=database)
        return connect

    # 断表是否存在
    def table_exists(self, cursor, table_name):
        cursor.execute("show tables;")
        tables = [cursor.fetchall()]
        table_list = re.findall('(\'.*?\')',str(tables))
        table_list = [re.sub("'",'',each) for each in table_list]

        if table_name in table_list:
            return 1
        else:
            return 0

    # 数据缓存源
    def temp_data(self):

        connect = self.db_connect()
        cursor = connect.cursor()
        sql = '''
            insert into `eshianyycf`(
                id
                ,cname
                ,ename
                ,spfenlei
                ,keshibu
                ,laiyuan
                ,chandi
                ,nengliang
                ,danbaizhi
                ,zhifang
                ,baohezhifang
                ,fanshizfs
                ,dbbhzfs
                ,duobbhzfs
                ,dangc
                ,tshhw
                ,tang
                ,rutang
                ,sanshiqw
                ,kesxssqw
                ,bsxssqw
                ,jinshuna
                ,weishengshua
                ,weishengshud
                ,weishengshue
                ,weishengshuk
                ,weishengshub1
                ,weishengshub2
                ,weishengshub6
                ,weishengshub12
                ,weishengshuc
                ,yanshuan
                ,yeshuan
                ,fanshuan
                ,shenwushu
                ,danjian
                ,jinshulin
                ,jinshujia
                ,jinshumei
                ,jinshugai
                ,jinshutie
                ,jinshuxin
                ,jinshudian
                ,jinshudxi
                ,jinshutong
                ,jinshufu
                ,jinshumeng
                ,deltae
                ,beitae
                ,aerfae
                ,hulubo
                ,zhifansz
                ,huifen
                ,shuifen
                ,nengliangqk
                ,xqurl
            )
            select
                id
                ,cname
                ,ename
                ,spfenlei
                ,keshibu
                ,laiyuan
                ,chandi
                ,nengliang
                ,danbaizhi
                ,zhifang
                ,baohezhifang
                ,fanshizfs
                ,dbbhzfs
                ,duobbhzfs
                ,dangc
                ,tshhw
                ,tang
                ,rutang
                ,sanshiqw
                ,kesxssqw
                ,bsxssqw
                ,jinshuna
                ,weishengshua
                ,weishengshud
                ,weishengshue
                ,weishengshuk
                ,weishengshub1
                ,weishengshub2
                ,weishengshub6
                ,weishengshub12
                ,weishengshuc
                ,yanshuan
                ,yeshuan
                ,fanshuan
                ,shenwushu
                ,danjian
                ,jinshulin
                ,jinshujia
                ,jinshumei
                ,jinshugai
                ,jinshutie
                ,jinshuxin
                ,jinshudian
                ,jinshudxi
                ,jinshutong
                ,jinshufu
                ,jinshumeng
                ,deltae
                ,beitae
                ,aerfae
                ,hulubo
                ,zhifansz
                ,huifen
                ,shuifen
                ,nengliangqk
                ,xqurl
            from `b205u294_eshianyycf`
            where(not exists (select
                id
                ,cname
                ,ename
                ,spfenlei
                ,keshibu
                ,laiyuan
                ,chandi
                ,nengliang
                ,danbaizhi
                ,zhifang
                ,baohezhifang
                ,fanshizfs
                ,dbbhzfs
                ,duobbhzfs
                ,dangc
                ,tshhw
                ,tang
                ,rutang
                ,sanshiqw
                ,kesxssqw
                ,bsxssqw
                ,jinshuna
                ,weishengshua
                ,weishengshud
                ,weishengshue
                ,weishengshuk
                ,weishengshub1
                ,weishengshub2
                ,weishengshub6
                ,weishengshub12
                ,weishengshuc
                ,yanshuan
                ,yeshuan
                ,fanshuan
                ,shenwushu
                ,danjian
                ,jinshulin
                ,jinshujia
                ,jinshumei
                ,jinshugai
                ,jinshutie
                ,jinshuxin
                ,jinshudian
                ,jinshudxi
                ,jinshutong
                ,jinshufu
                ,jinshumeng
                ,deltae
                ,beitae
                ,aerfae
                ,hulubo
                ,zhifansz
                ,huifen
                ,shuifen
                ,nengliangqk
                ,xqurl
            from `eshianyycf` where
                `eshianyycf`.id=`b205u294_eshianyycf`.id
            ))
            order by rand()
            limit 50;
        '''

        cursor.execute(sql)
        connect.commit()
        connect.close()
