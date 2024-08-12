
#測試資料
#會員等級對照表
insert into memberLv (lvName, lvBuff, lvAccumulate, createdBy, lastUpdatedBy) values ('銅牌會員', '回饋購物金為結帳金額5%', 0, 'chris', 'chris');
insert into memberLv (lvName, lvBuff, lvAccumulate, createdBy, lastUpdatedBy) values ('銀牌會員', '回饋購物金為結帳金額10%', 10000, 'chris', 'chris');
insert into memberLv (lvName, lvBuff, lvAccumulate, createdBy, lastUpdatedBy) values ('黃金會員', '回饋購物金為結帳金額15%', 30000, 'chris', 'chris');
insert into memberLv (lvName, lvBuff, lvAccumulate, createdBy, lastUpdatedBy) values ('鑽石會員', '回饋購物金為結帳金額20%', 50000, 'chris', 'chris');

#商品類型對照表
insert into productType (typeName, createdBy, lastUpdatedBy) values ('餅乾類', 'chris', 'chris');
insert into productType (typeName, createdBy, lastUpdatedBy) values ('蛋糕類', 'chris', 'chris');
insert into productType (typeName, createdBy, lastUpdatedBy) values ('水果塔類', 'chris', 'chris');
insert into productType (typeName, createdBy, lastUpdatedBy) values ('馬卡龍類', 'chris', 'chris');

#問題類型對照表
insert into quType (quTypeDesc, createdBy, lastUpdatedBy) values ('商品問題', 'chris', 'chris');
insert into quType (quTypeDesc, createdBy, lastUpdatedBy) values ('服務問題', 'chris', 'chris');
insert into quType (quTypeDesc, createdBy, lastUpdatedBy) values ('物流問題', 'chris', 'chris');
insert into quType (quTypeDesc, createdBy, lastUpdatedBy) values ('其他', 'chris', 'chris');

#縣市代碼對照表
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (1 ,'臺北市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (2 ,'新北市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (3 ,'基隆市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (4 ,'宜蘭縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (5 ,'新竹市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (6 ,'新竹縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (7 ,'桃園市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (8 ,'苗栗縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (9 ,'臺中市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (10 ,'彰化縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (11 ,'南投縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (12 ,'嘉義市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (13 ,'嘉義縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (14 ,'雲林縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (15 ,'臺南市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (16 ,'高雄市' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (17 ,'屏東縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (18 ,'臺東縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (19 ,'花蓮縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (20 ,'澎湖縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (21 ,'金門縣' ,'chris' ,'chris');
insert into county (cntCode ,cntName ,createdBy ,lastUpdatedBy) values (22 ,'連江縣' ,'chris' ,'chris');

#鄉鎮區代碼對照表
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (100 ,1 ,'中正區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (103 ,1 ,'大同區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (104 ,1 ,'中山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (105 ,1 ,'松山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (106 ,1 ,'大安區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (108 ,1 ,'萬華區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (110 ,1 ,'信義區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (111 ,1 ,'士林區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (112 ,1 ,'北投區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (114 ,1 ,'內湖區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (115 ,1 ,'南港區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (116 ,1 ,'文山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (207 ,2 ,'萬里區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (208 ,2 ,'金山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (220 ,2 ,'板橋區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (221 ,2 ,'汐止區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (222 ,2 ,'深坑區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (223 ,2 ,'石碇區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (224 ,2 ,'瑞芳區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (226 ,2 ,'平溪區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (227 ,2 ,'雙溪區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (228 ,2 ,'貢寮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (231 ,2 ,'新店區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (232 ,2 ,'坪林區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (233 ,2 ,'烏來區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (234 ,2 ,'永和區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (235 ,2 ,'中和區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (236 ,2 ,'土城區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (237 ,2 ,'三峽區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (238 ,2 ,'樹林區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (239 ,2 ,'鶯歌區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (241 ,2 ,'三重區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (242 ,2 ,'新莊區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (243 ,2 ,'泰山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (244 ,2 ,'林口區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (247 ,2 ,'蘆洲區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (248 ,2 ,'五股區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (249 ,2 ,'八里區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (251 ,2 ,'淡水區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (252 ,2 ,'三芝區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (253 ,2 ,'石門區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (200 ,3 ,'仁愛區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (201 ,3 ,'信義區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (202 ,3 ,'中正區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (203 ,3 ,'中山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (204 ,3 ,'安樂區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (205 ,3 ,'暖暖區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (206 ,3 ,'七堵區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (260 ,4 ,'宜蘭市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (261 ,4 ,'頭城鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (262 ,4 ,'礁溪鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (263 ,4 ,'壯圍鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (264 ,4 ,'員山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (265 ,4 ,'羅東鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (266 ,4 ,'三星鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (267 ,4 ,'大同鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (268 ,4 ,'五結鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (269 ,4 ,'冬山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (270 ,4 ,'蘇澳鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (272 ,4 ,'南澳鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (290 ,4 ,'釣魚臺' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (300031 ,5 ,'東區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (300013 ,5 ,'北區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (300109 ,5 ,'香山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (302 ,6 ,'竹北市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (303 ,6 ,'湖口鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (304 ,6 ,'新豐鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (305 ,6 ,'新埔鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (306 ,6 ,'關西鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (307 ,6 ,'芎林鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (308 ,6 ,'寶山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (310 ,6 ,'竹東鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (311 ,6 ,'五峰鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (312 ,6 ,'橫山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (313 ,6 ,'尖石鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (314 ,6 ,'北埔鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (315 ,6 ,'峨眉鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (320 ,7 ,'中壢區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (324 ,7 ,'平鎮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (325 ,7 ,'龍潭區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (326 ,7 ,'楊梅區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (327 ,7 ,'新屋區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (328 ,7 ,'觀音區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (330 ,7 ,'桃園區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (333 ,7 ,'龜山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (334 ,7 ,'八德區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (335 ,7 ,'大溪區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (336 ,7 ,'復興區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (337 ,7 ,'大園區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (338 ,7 ,'蘆竹區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (350 ,8 ,'竹南鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (351 ,8 ,'頭份市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (352 ,8 ,'三灣鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (353 ,8 ,'南庄鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (354 ,8 ,'獅潭鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (356 ,8 ,'後龍鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (357 ,8 ,'通霄鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (358 ,8 ,'苑裡鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (360 ,8 ,'苗栗市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (361 ,8 ,'造橋鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (362 ,8 ,'頭屋鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (363 ,8 ,'公館鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (364 ,8 ,'大湖鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (365 ,8 ,'泰安鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (366 ,8 ,'銅鑼鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (367 ,8 ,'三義鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (368 ,8 ,'西湖鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (369 ,8 ,'卓蘭鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (400 ,9 ,'中區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (401 ,9 ,'東區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (402 ,9 ,'南區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (403 ,9 ,'西區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (404 ,9 ,'北區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (406 ,9 ,'北屯區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (407 ,9 ,'西屯區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (408 ,9 ,'南屯區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (411 ,9 ,'太平區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (412 ,9 ,'大里區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (413 ,9 ,'霧峰區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (414 ,9 ,'烏日區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (420 ,9 ,'豐原區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (421 ,9 ,'后里區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (422 ,9 ,'石岡區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (423 ,9 ,'東勢區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (424 ,9 ,'和平區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (426 ,9 ,'新社區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (427 ,9 ,'潭子區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (428 ,9 ,'大雅區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (429 ,9 ,'神岡區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (432 ,9 ,'大肚區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (433 ,9 ,'沙鹿區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (434 ,9 ,'龍井區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (435 ,9 ,'梧棲區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (436 ,9 ,'清水區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (437 ,9 ,'大甲區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (438 ,9 ,'外埔區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (439 ,9 ,'大安區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (500 ,10 ,'彰化市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (502 ,10 ,'芬園鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (503 ,10 ,'花壇鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (504 ,10 ,'秀水鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (505 ,10 ,'鹿港鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (506 ,10 ,'福興鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (507 ,10 ,'線西鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (508 ,10 ,'和美鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (509 ,10 ,'伸港鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (510 ,10 ,'員林市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (511 ,10 ,'社頭鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (512 ,10 ,'永靖鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (513 ,10 ,'埔心鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (514 ,10 ,'溪湖鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (515 ,10 ,'大村鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (516 ,10 ,'埔鹽鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (520 ,10 ,'田中鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (521 ,10 ,'北斗鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (522 ,10 ,'田尾鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (523 ,10 ,'埤頭鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (524 ,10 ,'溪州鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (525 ,10 ,'竹塘鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (526 ,10 ,'二林鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (527 ,10 ,'大城鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (528 ,10 ,'芳苑鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (530 ,10 ,'二水鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (540 ,11 ,'南投市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (541 ,11 ,'中寮鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (542 ,11 ,'草屯鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (544 ,11 ,'國姓鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (545 ,11 ,'埔里鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (546 ,11 ,'仁愛鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (551 ,11 ,'名間鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (552 ,11 ,'集集鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (553 ,11 ,'水里鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (555 ,11 ,'魚池鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (556 ,11 ,'信義鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (557 ,11 ,'竹山鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (558 ,11 ,'鹿谷鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (600045 ,12 ,'東區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (600055 ,12 ,'西區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (602 ,13 ,'番路鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (603 ,13 ,'梅山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (604 ,13 ,'竹崎鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (605 ,13 ,'阿里山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (606 ,13 ,'中埔鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (607 ,13 ,'大埔鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (608 ,13 ,'水上鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (611 ,13 ,'鹿草鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (612 ,13 ,'太保市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (613 ,13 ,'朴子市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (614 ,13 ,'東石鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (615 ,13 ,'六腳鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (616 ,13 ,'新港鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (621 ,13 ,'民雄鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (622 ,13 ,'大林鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (623 ,13 ,'溪口鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (624 ,13 ,'義竹鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (625 ,13 ,'布袋鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (630 ,14 ,'斗南鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (631 ,14 ,'大埤鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (632 ,14 ,'虎尾鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (633 ,14 ,'土庫鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (634 ,14 ,'褒忠鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (635 ,14 ,'東勢鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (636 ,14 ,'臺西鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (637 ,14 ,'崙背鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (638 ,14 ,'麥寮鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (640 ,14 ,'斗六市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (643 ,14 ,'林內鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (646 ,14 ,'古坑鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (647 ,14 ,'莿桐鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (648 ,14 ,'西螺鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (649 ,14 ,'二崙鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (651 ,14 ,'北港鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (652 ,14 ,'水林鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (653 ,14 ,'口湖鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (654 ,14 ,'四湖鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (655 ,14 ,'元長鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (700 ,15 ,'中西區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (701 ,15 ,'東區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (702 ,15 ,'南區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (704 ,15 ,'北區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (708 ,15 ,'安平區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (709 ,15 ,'安南區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (710 ,15 ,'永康區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (711 ,15 ,'歸仁區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (712 ,15 ,'新化區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (713 ,15 ,'左鎮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (714 ,15 ,'玉井區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (715 ,15 ,'楠西區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (716 ,15 ,'南化區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (717 ,15 ,'仁德區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (718 ,15 ,'關廟區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (719 ,15 ,'龍崎區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (720 ,15 ,'官田區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (721 ,15 ,'麻豆區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (722 ,15 ,'佳里區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (723 ,15 ,'西港區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (724 ,15 ,'七股區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (725 ,15 ,'將軍區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (726 ,15 ,'學甲區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (727 ,15 ,'北門區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (730 ,15 ,'新營區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (731 ,15 ,'後壁區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (732 ,15 ,'白河區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (733 ,15 ,'東山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (734 ,15 ,'六甲區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (735 ,15 ,'下營區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (736 ,15 ,'柳營區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (737 ,15 ,'鹽水區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (741 ,15 ,'善化區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (742 ,15 ,'大內區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (743 ,15 ,'山上區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (744 ,15 ,'新市區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (745 ,15 ,'安定區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (800 ,16 ,'新興區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (801 ,16 ,'前金區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (802 ,16 ,'苓雅區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (803 ,16 ,'鹽埕區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (804 ,16 ,'鼓山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (805 ,16 ,'旗津區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (806 ,16 ,'前鎮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (807 ,16 ,'三民區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (811 ,16 ,'楠梓區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (812 ,16 ,'小港區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (813 ,16 ,'左營區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (814 ,16 ,'仁武區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (815 ,16 ,'大社區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (820 ,16 ,'岡山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (821 ,16 ,'路竹區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (822 ,16 ,'阿蓮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (823 ,16 ,'田寮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (824 ,16 ,'燕巢區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (825 ,16 ,'橋頭區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (826 ,16 ,'梓官區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (827 ,16 ,'彌陀區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (828 ,16 ,'永安區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (829 ,16 ,'湖內區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (830 ,16 ,'鳳山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (831 ,16 ,'大寮區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (832 ,16 ,'林園區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (833 ,16 ,'鳥松區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (840 ,16 ,'大樹區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (842 ,16 ,'旗山區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (843 ,16 ,'美濃區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (844 ,16 ,'六龜區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (845 ,16 ,'內門區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (846 ,16 ,'杉林區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (847 ,16 ,'甲仙區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (848 ,16 ,'桃源區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (849 ,16 ,'那瑪夏區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (851 ,16 ,'茂林區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (852 ,16 ,'茄萣區' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (900 ,17 ,'屏東市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (901 ,17 ,'三地門鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (902 ,17 ,'霧臺鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (903 ,17 ,'瑪家鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (904 ,17 ,'九如鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (905 ,17 ,'里港鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (906 ,17 ,'高樹鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (907 ,17 ,'鹽埔鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (908 ,17 ,'長治鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (909 ,17 ,'麟洛鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (911 ,17 ,'竹田鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (912 ,17 ,'內埔鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (913 ,17 ,'萬丹鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (920 ,17 ,'潮州鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (921 ,17 ,'泰武鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (922 ,17 ,'來義鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (923 ,17 ,'萬巒鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (924 ,17 ,'崁頂鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (925 ,17 ,'新埤鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (926 ,17 ,'南州鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (927 ,17 ,'林邊鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (928 ,17 ,'東港鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (929 ,17 ,'琉球鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (931 ,17 ,'佳冬鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (932 ,17 ,'新園鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (940 ,17 ,'枋寮鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (941 ,17 ,'枋山鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (942 ,17 ,'春日鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (943 ,17 ,'獅子鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (944 ,17 ,'車城鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (945 ,17 ,'牡丹鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (946 ,17 ,'恆春鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (947 ,17 ,'滿州鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (950 ,18 ,'臺東市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (951 ,18 ,'綠島鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (952 ,18 ,'蘭嶼鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (953 ,18 ,'延平鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (954 ,18 ,'卑南鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (955 ,18 ,'鹿野鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (956 ,18 ,'關山鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (957 ,18 ,'海端鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (958 ,18 ,'池上鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (959 ,18 ,'東河鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (961 ,18 ,'成功鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (962 ,18 ,'長濱鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (963 ,18 ,'太麻里鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (964 ,18 ,'金峰鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (965 ,18 ,'大武鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (966 ,18 ,'達仁鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (970 ,19 ,'花蓮市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (971 ,19 ,'新城鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (972 ,19 ,'秀林鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (973 ,19 ,'吉安鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (974 ,19 ,'壽豐鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (975 ,19 ,'鳳林鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (976 ,19 ,'光復鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (977 ,19 ,'豐濱鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (978 ,19 ,'瑞穗鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (979 ,19 ,'萬榮鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (981 ,19 ,'玉里鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (982 ,19 ,'卓溪鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (983 ,19 ,'富里鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (880 ,20 ,'馬公市' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (881 ,20 ,'西嶼鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (882 ,20 ,'望安鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (883 ,20 ,'七美鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (884 ,20 ,'白沙鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (885 ,20 ,'湖西鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (890 ,21 ,'金沙鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (891 ,21 ,'金湖鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (892 ,21 ,'金寧鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (893 ,21 ,'金城鎮' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (894 ,21 ,'烈嶼鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (896 ,21 ,'烏坵鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (209 ,22 ,'南竿鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (210 ,22 ,'北竿鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (211 ,22 ,'莒光鄉' ,'chris' ,'chris');
insert into district (distCode ,cntCode ,distName ,createdBy, lastUpdatedBy) values (212 ,22 ,'東引鄉' ,'chris' ,'chris');

#會員資料
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (1, 'test01', 'w7764z38', '陳沛聖', '1992-12-29', '0952780126', 'alexis9984@gmail.com', 14, 643, '公園79號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (2, 'test02', 'BQC7r43e', '黎拓苑', '1991-07-13', '0987448924', 'parker5394@gmail.com', 16, 829, '忠孝街19號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (3, 'test03', '52k2X8v2', '廖嘉銀', '1988-09-04', '0913556230', 'christina4998@outlook.com', 8, 350, '福德路22號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (4, 'test04', 'PNbmhAkN', '宋愛永', '1995-07-15', '0923443082', 'maria5390@gmail.com', 9, 408, '龍富十一街90號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (1, 'test05', 'G4qX79vF', '鄒巖風', '1965-10-30', '0912639012', 'schuyler6816@yahoo.com', 1, 103, '市民大道1段39號之8', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (2, 'test06', 'fewXctD3', '王小明', '1986-04-06', '0912410805', 'hart9626@gmail.com', 16, 813, '軍校路66號之6', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (3, 'test07', '355uKDhy', '呂靖駱', '2010-01-04', '0932086114', 'reynes5203@gmail.com', 13, 621, '江厝店42號', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (4, 'test08', '8v59wwg6', '曾盧碧', '1999-10-22', '0915121211', 'erin607@gmail.com', 19, 983, '吳江8號', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (1, 'test09', 'mHc87w6U', '陳慶方', '1986-01-26', '0971533998', 'rodney9753@outlook.com', 2, 227, '聖南89號6樓', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (2, 'test10', 'd2uy4X3E', '李真鈺', '1961-06-11', '0986509620', 'selina3163@gmail.com', 17, 909, '信義路22號', 0, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (3, 'test11', 'HB67c9En', '張小明', '2013-09-20', '0919788045', 'bates2631@gmail.com', 7, 326, '新農街24號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (4, 'test12', 'u477Uz79', '郭汶瑋', '2019-10-30', '0934960786', 'riperton4256@outlook.com', 7, 338, '上竹四街66號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (1, 'test13', 'agb38xh8', '溫冠琦', '1995-03-15', '0987408646', 'maria8056@yahoo.com', 16, 842, '竹箋寮巷81號之12', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (2, 'test14', '57L6KzDb', '劉山杉', '1966-06-07', '0956902732', 'chet8352@gmail.com', 7, 334, '豐田三路64號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (3, 'test15', 'bL38ZAC6', '蘇以冠', '1995-01-01', '0989153074', 'cassidy975@hotmail.com', 11, 557, '大明路36號3樓', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (4, 'test16', '5372EWU5', '張嬋艾', '2002-12-11', '0923010423', 'anna5108@outlook.com', 18, 961, '民富路30號之4', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (1, 'test17', '9746y72E', '林森楚', '1987-01-13', '0933318243', 'bailey5829@hotmail.com', 9, 411, '大源十六街26號3樓', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (2, 'test18', 'gddrXw8f', '張泓鑾', '1976-03-12', '0927778560', 'jalen2425@gmail.com', 12, 300031, '後厝仔67號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (3, 'test19', 'cLK858CE', '巫月樹', '1996-08-19', '0963280161', 'donovan8470@gmail.com', 15, 712, '茄冬坑78號', 1, 'chris', 'chris');
insert into member (memberLvId, account, password, name, birthDt, phone, email, cntCode, distCode, address, status, createdBy, lastUpdatedBy) values (4, 'test20', '3Q6x3nV6', '黎天洪', '1982-10-09', '0970521356', 'morgan7795@yahoo.com', 2, 231, '直潭六街17號', 1, 'chris', 'chris');

#商品基本資料
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '巧克力慕斯蛋糕', 350, 5, 10, 0, 0, 1, '濃郁巧克力口感，入口即化，帶來無與倫比的甜蜜享受。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '草莓奶油蛋糕', 400, 5, 20, 0, 0, 1, '新鮮草莓搭配香濃奶油，甜美可口，讓人一試成主顧。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '綜合水果蛋糕', 450, 5, 30, 0, 0, 1, '多種新鮮水果搭配，清新美味，帶來豐富的口感層次。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (3, '檸檬塔', 250, 5, 15, 0, 0, 1, '酸甜檸檬餡，搭配酥脆塔皮，每一口都是酸甜爽口的享受。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '芒果乳酪蛋糕', 380, 5, 25, 0, 0, 0, '芒果香甜，乳酪濃郁滑順，讓人無法抗拒的美味組合。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '藍莓起司蛋糕', 420, 5, 5, 0, 0, 0, '藍莓酸甜，起司香濃，口感豐富，讓人一口接一口。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '綠茶紅豆蛋糕', 360, 5, 10, 0, 0, 0, '綠茶濃郁，紅豆香甜，日式風味，獨特又美味。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '核桃咖啡蛋糕', 320, 5, 20, 0, 0, 0, '核桃脆口，咖啡香氣濃郁，完美搭配。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '抹茶生巧克力蛋糕', 370, 5, 30, 0, 0, 0, '抹茶濃郁，巧克力滑順，帶來雙重口感享受。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '玫瑰香草蛋糕', 430, 5, 10, 0, 0, 1, '玫瑰香氣撲鼻，香草細膩柔和，口感豐富。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '奶油酥餅', 180, 5, 20, 0, 0, 1, '奶油香濃，酥脆可口，每一口都令人回味無窮。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '杏仁餅乾', 150, 5, 30, 0, 0, 1, '杏仁香氣濃郁，口感酥脆，讓人一吃就停不下來。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '花生奶油餅乾', 160, 5, 30, 0, 0, 1, '花生香濃，奶油滑順，口感豐富，是茶點的最佳選擇。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '可可曲奇餅', 200, 5, 15, 0, 0, 1, '可可香濃，酥脆可口，每一口都是濃郁的可可享受。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (4, '香草馬卡龍', 220, 5, 25, 0, 0, 1, '馬卡龍香脆，香草濃郁，甜而不膩，令人愛不釋手。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '檸檬酥餅', 190, 5, 30, 0, 0, 1, '檸檬清新，酥脆爽口，帶來清爽的味蕾享受。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (1, '蔓越莓餅乾', 170, 5, 15, 0, 0, 1, '蔓越莓酸甜，餅乾酥脆，口感豐富，是下午茶的絕佳搭配。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '巧克力布朗尼', 300, 5, 25, 0, 0, 1, '濃郁巧克力，口感濕潤，每一口都是絕佳的巧克力體驗。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '太妃糖核桃蛋糕', 40, 5, 20, 0, 0, 1, '太妃糖香甜，核桃香脆，甜而不膩，讓人回味無窮。', 'chris', 'chris');
insert into productInfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proStatus, proDesc, createdBy, lastUpdatedBy) values (2, '紅絲絨蛋糕', 410, 5, 30, 0, 0, 1, '絲絨般細膩，奶油濃郁，每一口都是甜蜜的享受。', 'chris', 'chris');

#促銷活動
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('元旦迎新甜點禮', '2024-1-1', '2024-1-5', 8.00, 2, '元旦期間推出特別組合禮盒，餅乾與蛋糕組合特價8折優惠，讓您迎接新年更添甜美滋味。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('情人節心動甜點禮盒', '2024-2-10', '2024-2-14', 9.00, 2, '情人節限定甜點禮盒，搭配愛心巧克力餅乾，享9折優惠，為愛情加點甜。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('新春福袋甜點驚喜', '2024-2-10', '2024-2-17', 8.50, 2, '新年期間購買福袋85折優惠，內含多款驚喜甜點，還有機會抽中限量大禮品，數量有限，售完為止。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('元宵節燈籠甜點派對', '2024-2-22', '2024-2-24', 9.00, 2, '元宵節全館9折優惠，購買任何商品即贈精美手工燈籠一個，搭配特色糕點，讓節日氣氛更加濃厚。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('母親節感恩蛋糕禮', '2024-5-1', '2024-5-12', 8.00, 2, '母親節期間購買指定蛋糕，享8折優惠，再加贈特製心形餅乾，感恩母愛無價。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('端午粽香糕點饗宴', '2024-6-1', '2024-6-10', 9.50, 2, '端午節期間購買任一蛋糕享95折，即贈送迷你粽子兩顆，與家人共享甜蜜與傳統的美好滋味。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('父親節尊榮甜點禮遇', '2024-8-1', '2024-8-8', 8.80, 1, '父親節期間購買任何蛋糕，即可享88折優惠，並贈送特製尊榮餅乾一盒，表達對父親的敬意。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('七夕情人節甜蜜雙重奏', '2024-8-1', '2024-8-10', 5.00, 1, '七夕情人節限定雙人甜點禮盒，享半價優惠，與摯愛共度甜蜜浪漫時光。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('中元普渡糕點福袋', '2024-8-10', '2024-8-24', 7.00, 1, '中元節期間購買特製普渡糕點福袋，再享7折優惠，讓普渡更加圓滿豐盛。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('中秋月圓禮盒特惠', '2024-9-1', '2024-9-17', 9.00, 0, '中秋節期間購買精選月餅禮盒，全館享9折優惠，並贈送手工餅乾一包。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('重陽節敬老糕點禮盒', '2024-10-1', '2024-10-9', 5.00, 0, '重陽節期間購買雙份糕點禮盒，享半價優惠，送給長輩最貼心的敬老禮物。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('周年慶感恩大回饋', '2024-11-1', '2024-11-3', 8.50, 0, '周年慶期間全店蛋糕與餅乾全面85折，並享滿額贈活動，感謝顧客的支持與厚愛。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('冬至暖心湯圓糕點組合', '2024-12-3', '2024-12-22', 5.00, 0, '冬至期間購買任意蛋糕，搭配湯圓享半價優惠，讓您在寒冬中感受甜蜜溫暖。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('聖誕節甜蜜分享季', '2024-12-3', '2024-12-25', 8.00, 0, '聖誕節期間購買任一蛋糕即享8折優惠，即贈送迷你餅乾禮盒一份，與親朋好友一同分享佳節甜蜜。', 'chris', 'chris');
insert into event (eventName, startDt, endDt, eventDiscount, status, eventContent, createdBy, lastUpdatedBy) values ('跨年甜點狂歡夜', '2024-12-25', '2024-12-31', 8.50, 0, '跨年倒數夜購買指定蛋糕享85折，與家人好友一起迎接新年的甜蜜時刻。', 'chris', 'chris');

#員工資料
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7001' ,'chris' ,'0912345678' ,'staff7001@gmail.com' ,'2024-02-01' ,1 ,1 ,'chris' ,'chris');
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7002' ,'阿維' ,'0914575670' ,'staff7002@gmail.com' ,'2016-5-25' ,1 ,1 ,'chris' ,'chris');
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7003' ,'丁丁' ,'096335676' ,'staff7003@gmail.com' ,'2021-06-01' ,1 ,1 ,'chris' ,'chris');
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7004' ,'西卡' ,'0965454675' ,'staff7004@gmail.com' ,'2023-11-10' ,1 ,1 ,'chris' ,'chris');
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7005' ,'梅子' ,'0927543764' ,'staff7005@gmail.com' ,'2020-07-25' ,1 ,1 ,'chris' ,'chris');
insert into staff (password ,name ,phone ,email ,employDt ,status ,permission ,createdBy ,lastUpdatedBy) values ('test7006' ,'威慶' ,'0960765177' ,'staff7006@gmail.com' ,'2024-02-11' ,1 ,1 ,'chris' ,'chris');

#訂單紀錄
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (1, null, null, '2024-07-01', 2500, 0, 0, 2500, 3, 1, 3, 1, 0, 0, '陳沛聖', '2045675498763421', 30, '05', '123', 2, '', 'AZS873', '陳沛聖', '0952780126', 14, 643, '公園79號', '陳沛聖', 'chris');
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (1, null, null, '2024-08-09', 2800, 0, 0, 2800, 1, 1, 0, 2, 0, 0, '陳沛聖', '2045675498763421', 30, '05', '123', 1, '', '', '陳沛聖', '0952780126', 14, 643, '公園79號', '陳沛聖', 'chris');
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (2, null, null, '2024-06-20', 3500, 300, 200, 3000, 3, 2, 3, 2, 1, 1, '黎拓苑', '', null, '', '', 1, '', '', '黎拓苑', '0987448924', 16, 829, '忠孝街19號', '黎拓苑', 'chris');
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (2, null, null, '2024-08-08', 1200, 200, 0, 1000, 0, 1, 0, 1, 1, 0, '黎拓苑', '3628463895746374', 28, '01', '456', 2, '13275647', '', '黎拓苑', '0987448924', 16, 829, '忠孝街19號', '黎拓苑', 'chris');
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (3, null, null, '2024-02-07', 2100, 0, 100, 2000, 1, 1, 1, 1, 0, 1, '廖嘉銀', '5463987612658830', 26, '02', '232', 2, '', 'BJH469', '廖嘉銀', '0913556230', 8, 350, '福德路22號', '廖嘉銀', 'chris');
insert into orderList (memberId, couponId, eventId, orderDt, orderAmount, couponUsedAmount, coinUsedAmount, payAmount, orderStatus, paymentMethod, paymentStatus, pickupMethod, useCoupon, useCoin, cardHolder, cardNumber, cardYy, cardMm, cardVerifyCode, invoiceWay, invoiceTaxNo, invoiceMobileCode, recipientName, recipientPhone, recipientCnt, recipientDist, recipientAddress, createdBy, lastUpdatedBy) values (3, null, null, '2024-05-31', 4700, 0, 350, 4350, 1, 2, 1, 2, 0, 1, '廖嘉銀', '', null, '', '', 2, '', 'BJH469', '廖嘉銀', '0913556230', 8, 350, '福德路22號', '廖嘉銀', 'chris');

#門市資料
insert into store (storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, lastUpdatedBy) values ('慶城店', 1, 105, '台北市松山區慶城街2號', '25.2', '23.2', '0227163388', '09:00-21:00', 'teamagichand@gmail.com', 'chris', 'chris');
insert into store (storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, lastUpdatedBy) values ('內壢店', 7, 320, '桃園市中壢區文化路348號', '23.5', '22.4', '034351331', '11:00-21:00', 'abc@gmail.com', 'chris', 'chris');
insert into store (storeName, cntCode, distCode, storeAddress, longitude, latitude, storePhone, openingHours, storeMail, createdBy, lastUpdatedBy) values ('臨江通化店', 1, 106, '台北市大安區通化街72號', '22.1', '24.3', '0227331914', '10:00-22:00', 'dfg@gmail.com', 'chris', 'chris');

#優惠券
INSERT INTO coupon (couponCode, couponName, couponStatus, startDt, endDt, discType, discAmount, discPercentage, createdBy, lastUpdatedBy)
VALUES
    ('MOTHERSDAY', '母親節感恩優惠: 全館82折', 1, '2024-05-08', '2024-05-12', 2, NULL, 0.82, 'Nicole Kidman', 'Nicole Kidman'),
    ('QINGMING', '清明節追思優惠: 折抵80元', 1, '2024-04-04', '2024-04-06', 1, 80, NULL, 'Jackie Chan', 'Jackie Chan'),
    ('SHOPPING618', '618購物節: 全場68折', 1, '2024-06-18', '2024-06-20', 2, NULL, 0.68, 'Gal Gadot', 'Gal Gadot'),
    ('CNNEWYEAR', '農曆春節大禮包: 折抵288元', 1, '2025-01-29', '2025-02-02', 1, 288, NULL, 'Keanu Reeves', 'Keanu Reeves'),
    ('FATHERSDAY', '父親節感謝優惠: 全館88折', 1, '2024-08-08', '2024-08-09', 2, NULL, 0.88, 'Dwayne Johnson', 'Dwayne Johnson'),
    ('NEWYEAR2024', '新年優惠: 全館9折', 1, '2024-01-01', '2024-01-15', 2, NULL, 0.90, 'Emma Watson', 'Emma Watson'),
    ('VALENTINE14', '情人節特惠: 折抵100元', 1, '2024-02-10', '2024-02-14', 1, 100, NULL, 'Tom Hardy', 'Tom Hardy'),
    ('MARCH8WOMEN', '三八婦女節: 全館85折', 1, '2024-03-06', '2024-03-08', 2, NULL, 0.85, 'Scarlett Johansson', 'Scarlett Johansson'),
    ('FOOL1APR', '愚人節促銷: 折抵50元', 1, '2024-04-01', '2024-04-02', 1, 50, NULL, 'Chris Hemsworth', 'Chris Hemsworth'),
    ('LABORMAY1', '勞動節優惠: 全館88折', 1, '2024-04-29', '2024-05-01', 2, NULL, 0.88, 'Natalie Portman', 'Natalie Portman'),
    ('DRAGONBOAT', '端午節折扣: 折抵150元', 1, '2024-06-10', '2024-06-12', 1, 150, NULL, 'Robert Downey Jr.', 'Robert Downey Jr.'),
    ('SUMMER2024', '夏日清涼價: 全館8折', 1, '2024-07-01', '2024-07-31', 2, NULL, 0.80, 'Jennifer Lawrence', 'Jennifer Lawrence'),
    ('GHOST95', '中元節全館95折', 1, '2024-08-15', '2024-08-30', 2, NULL, 0.95, 'Chris Evans', 'Chris Evans'),
    ('MOONFEST', '中秋節優惠: 折抵200元', 1, '2024-09-15', '2024-09-17', 1, 200, NULL, 'Margot Robbie', 'Margot Robbie'),
    ('NATIONAL10', '國慶日特惠: 全館9折', 1, '2024-10-01', '2024-10-07', 2, NULL, 0.90, 'Ryan Gosling', 'Ryan Gosling'),
    ('SINGLES11', '光棍節促銷: 折抵111元', 1, '2024-11-11', '2024-11-11', 1, 111, NULL, 'Emma Stone', 'Emma Stone'),
    ('XMAS2024', '聖誕節大促: 全館75折', 1, '2024-12-24', '2024-12-26', 2, NULL, 0.75, 'Hugh Jackman', 'Hugh Jackman'),
    ('YEAREND24', '年終大清倉: 全館7折', 1, '2024-12-28', '2024-12-31', 2, NULL, 0.70, 'Anne Hathaway', 'Anne Hathaway'),
    ('NEWMEMBER', '會員優惠: 折抵50元', 1, '2024-01-01', '2024-12-31', 1, 50, NULL, 'Leonardo DiCaprio', 'Leonardo DiCaprio'),
    ('BDAYTREAT', '周年慶優惠: 全館85折', 1, '2024-01-01', '2024-12-31', 2, NULL, 0.85, 'Meryl Streep', 'Meryl Streep'),
    ('VIPCLUB', 'VIP會員專屬: 全館88折', 1, '2024-01-01', '2024-12-31', 2, NULL, 0.88, 'Brad Pitt', 'Brad Pitt'),
    ('FLASHSALE', '限時閃購: 全館7折', 0, '2024-05-01', '2024-05-03', 2, NULL, 0.70, 'Angelina Jolie', 'Angelina Jolie'),
    ('FREESHIP100', '限時免運', 1, '2024-03-01', '2024-03-31', 1, 80, NULL, 'Tom Hanks', 'Tom Hanks'),
    ('GREENEARTH', '餅乾85折優惠', 1, '2024-04-22', '2024-04-22', 2, NULL, 0.85, 'Julia Roberts', 'Julia Roberts'),
    ('BACKSCHOOL', '開學季折扣: 折抵100元', 1, '2024-08-20', '2024-09-05', 1, 100, NULL, 'Will Smith', 'Will Smith');

#優惠券
INSERT INTO coupon (couponCode, couponName, couponStatus, startDt, endDt, discType, discAmount, discPercentage, createdBy, lastUpdatedBy)
VALUES
    ('MOTHERSDAY', '母親節感恩優惠: 全館82折', 1, '2024-05-08', '2024-05-12', 2, NULL, 0.82, 'Nicole Kidman', 'Nicole Kidman'),
    ('QINGMING', '清明節追思優惠: 折抵80元', 1, '2024-04-04', '2024-04-06', 1, 80, NULL, 'Jackie Chan', 'Jackie Chan'),
    ('SHOPPING618', '618購物節: 全場68折', 1, '2024-06-18', '2024-06-20', 2, NULL, 0.68, 'Gal Gadot', 'Gal Gadot'),
    ('CNNEWYEAR', '農曆春節大禮包: 折抵288元', 1, '2025-01-29', '2025-02-02', 1, 288, NULL, 'Keanu Reeves', 'Keanu Reeves'),
    ('FATHERSDAY', '父親節感謝優惠: 全館88折', 1, '2024-08-08', '2024-08-09', 2, NULL, 0.88, 'Dwayne Johnson', 'Dwayne Johnson'),
    ('NEWYEAR2024', '新年優惠: 全館9折', 1, '2024-01-01', '2024-01-15', 2, NULL, 0.90, 'Emma Watson', 'Emma Watson'),
    ('VALENTINE14', '情人節特惠: 折抵100元', 1, '2024-02-10', '2024-02-14', 1, 100, NULL, 'Tom Hardy', 'Tom Hardy'),
    ('MARCH8WOMEN', '三八婦女節: 全館85折', 1, '2024-03-06', '2024-03-08', 2, NULL, 0.85, 'Scarlett Johansson', 'Scarlett Johansson'),
    ('FOOL1APR', '愚人節促銷: 折抵50元', 1, '2024-04-01', '2024-04-02', 1, 50, NULL, 'Chris Hemsworth', 'Chris Hemsworth'),
    ('LABORMAY1', '勞動節優惠: 全館88折', 1, '2024-04-29', '2024-05-01', 2, NULL, 0.88, 'Natalie Portman', 'Natalie Portman'),
    ('DRAGONBOAT', '端午節折扣: 折抵150元', 1, '2024-06-10', '2024-06-12', 1, 150, NULL, 'Robert Downey Jr.', 'Robert Downey Jr.'),
    ('SUMMER2024', '夏日清涼價: 全館8折', 1, '2024-07-01', '2024-07-31', 2, NULL, 0.80, 'Jennifer Lawrence', 'Jennifer Lawrence'),
    ('GHOST95', '中元節全館95折', 1, '2024-08-15', '2024-08-30', 2, NULL, 0.95, 'Chris Evans', 'Chris Evans'),
    ('MOONFEST', '中秋節優惠: 折抵200元', 1, '2024-09-15', '2024-09-17', 1, 200, NULL, 'Margot Robbie', 'Margot Robbie'),
    ('NATIONAL10', '國慶日特惠: 全館9折', 1, '2024-10-01', '2024-10-07', 2, NULL, 0.90, 'Ryan Gosling', 'Ryan Gosling'),
    ('SINGLES11', '光棍節促銷: 折抵111元', 1, '2024-11-11', '2024-11-11', 1, 111, NULL, 'Emma Stone', 'Emma Stone'),
    ('XMAS2024', '聖誕節大促: 全館75折', 1, '2024-12-24', '2024-12-26', 2, NULL, 0.75, 'Hugh Jackman', 'Hugh Jackman'),
    ('YEAREND24', '年終大清倉: 全館7折', 1, '2024-12-28', '2024-12-31', 2, NULL, 0.70, 'Anne Hathaway', 'Anne Hathaway'),
    ('NEWMEMBER', '會員優惠: 折抵50元', 1, '2024-01-01', '2024-12-31', 1, 50, NULL, 'Leonardo DiCaprio', 'Leonardo DiCaprio'),
    ('BDAYTREAT', '周年慶優惠: 全館85折', 1, '2024-01-01', '2024-12-31', 2, NULL, 0.85, 'Meryl Streep', 'Meryl Streep'),
    ('VIPCLUB', 'VIP會員專屬: 全館88折', 1, '2024-01-01', '2024-12-31', 2, NULL, 0.88, 'Brad Pitt', 'Brad Pitt'),
    ('FLASHSALE', '限時閃購: 全館7折', 0, '2024-05-01', '2024-05-03', 2, NULL, 0.70, 'Angelina Jolie', 'Angelina Jolie'),
    ('FREESHIP100', '限時免運', 1, '2024-03-01', '2024-03-31', 1, 80, NULL, 'Tom Hanks', 'Tom Hanks'),
    ('GREENEARTH', '餅乾85折優惠', 1, '2024-04-22', '2024-04-22', 2, NULL, 0.85, 'Julia Roberts', 'Julia Roberts'),
    ('BACKSCHOOL', '開學季折扣: 折抵100元', 1, '2024-08-20', '2024-09-05', 1, 100, NULL, 'Will Smith', 'Will Smith');
