
## How to start Postgres:

+ Download Postgres for your OS: https://www.postgresql.org/download/

+ create database named "database" with username: postgres and password 1234




### add product call
````
curl --location 'http://localhost:8080/data/products' \
--header 'Content-Type: application/json' \
--data '[
  {
    "productId": "BG-419110951",
    "category": "Babies",
    "brand": "Girlds"
  },
  {
    "productId": "BG-419110952",
    "category": "Babies",
    "brand": "Girlds"
  }
]'
````

### add scores
```
curl --location 'http://localhost:8080/data/shopper-score' \
--header 'Content-Type: application/json' \
--data '[
  {
    "shopperId": "S-1000",
    "shelf": [
      {
        "productId": "MB-2093193398",
        "relevancyScore": 31.089209569320897
      },
      {
        "productId": "VV-1280808856",
        "relevancyScore": 55.16626010671777
      },
      {
        "productId": "MD-543564697",
        "relevancyScore": 73.01492966268303
      },
      {
        "productId": "BB-2144746855",
        "relevancyScore": 4.465418091552332
      },
      {
        "productId": "MB-2093193397",
        "relevancyScore": 81.86596372052234
      },
      {
        "productId": "SC-860550238",
        "relevancyScore": 80.39179367642213
      },
      {
        "productId": "BG-419110952",
        "relevancyScore": 17.06951788069343
      },
      {
        "productId": "BM-1173639537",
        "relevancyScore": 67.02308880778921
      },
      {
        "productId": "MJ-373746710",
        "relevancyScore": 5.732323263667915
      },
      {
        "productId": "SS-1529984359",
        "relevancyScore": 82.6173683756812
      },
      {
        "productId": "MJ-373746711",
        "relevancyScore": 83.6325837366619
      },
      {
        "productId": "BC-989301224",
        "relevancyScore": 6.778058627746741
      },
      {
        "productId": "BB-2144746857",
        "relevancyScore": 85.39314011525776
      },
      {
        "productId": "VA-1329167330",
        "relevancyScore": 67.76365858050977
      },
      {
        "productId": "SB-51995577",
        "relevancyScore": 46.014451739635916
      }
    ]
  },
  {
    "shopperId": "S-1001",
    "shelf": [
      {
        "productId": "MD-543564695",
        "relevancyScore": 64.9399444667783
      },
      {
        "productId": "BB-2144746857",
        "relevancyScore": 53.57797793220851
      },
      {
        "productId": "VT-246442909",
        "relevancyScore": 21.288534107744482
      },
      {
        "productId": "VA-1329167330",
        "relevancyScore": 27.014437875539265
      },
      {
        "productId": "SS-1529984359",
        "relevancyScore": 62.1324134409292
      },
      {
        "productId": "BM-1173639539",
        "relevancyScore": 44.137367556050236
      },
      {
        "productId": "MM-749337360",
        "relevancyScore": 6.856912727184749
      },
      {
        "productId": "ST-348265157",
        "relevancyScore": 39.775934624141605
      },
      {
        "productId": "VB-1890577308",
        "relevancyScore": 96.8131613220743
      },
      {
        "productId": "BG-419110953",
        "relevancyScore": 4.430050876459301
      },
      {
        "productId": "VT-246442911",
        "relevancyScore": 99.38024632323383
      },
      {
        "productId": "VV-1280808854",
        "relevancyScore": 2.4611321887394677
      },
      {
        "productId": "MM-749337358",
        "relevancyScore": 24.346224227541345
      },
      {
        "productId": "MM-749337359",
        "relevancyScore": 58.574240950900524
      },
      {
        "productId": "MD-543564696",
        "relevancyScore": 37.505474308360355
      }
    ]
  },
  {
    "shopperId": "S-1002",
    "shelf": [
      {
        "productId": "VA-1329167330",
        "relevancyScore": 19.492734899351294
      },
      {
        "productId": "BB-2144746855",
        "relevancyScore": 52.970581137195005
      },
      {
        "productId": "SB-51995577",
        "relevancyScore": 71.96790001671006
      },
      {
        "productId": "SC-860550238",
        "relevancyScore": 43.95637045922845
      },
      {
        "productId": "ST-348265158",
        "relevancyScore": 63.53588332610439
      },
      {
        "productId": "VB-1890577306",
        "relevancyScore": 28.318408103977355
      },
      {
        "productId": "MD-543564697",
        "relevancyScore": 96.8270084353957
      },
      {
        "productId": "VV-1280808855",
        "relevancyScore": 9.605985097277658
      },
      {
        "productId": "MM-749337358",
        "relevancyScore": 51.47881070494537
      },
      {
        "productId": "MB-2093193399",
        "relevancyScore": 97.79320043226103
      },
      {
        "productId": "BC-989301223",
        "relevancyScore": 22.951332705537688
      },
      {
        "productId": "BG-419110953",
        "relevancyScore": 42.45475417967195
      },
      {
        "productId": "MD-543564695",
        "relevancyScore": 81.82907115868066
      },
      {
        "productId": "SS-1529984359",
        "relevancyScore": 20.116106438128845
      },
      {
        "productId": "MB-2093193398",
        "relevancyScore": 91.64193020313606
      }
    ]
  }
]'
```

### get products with filters
```
curl --location --request GET 'http://localhost:8080/ecommerce/products?shopperId=S-1000&category=Vegan&brand=Avocadow&limit=10' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'shopperId=yourShopperId' \
--data-urlencode 'category=optionalCategory' \
--data-urlencode 'brand=optionalBrand' \
--data-urlencode 'limit=optionalLimit'
```