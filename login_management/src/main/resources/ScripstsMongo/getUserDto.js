db.user.aggregate([
    {
        "$match": {
            "account.userName": "warrenxxx",
            "account.password": "123456"
        }
    },
    {
        "$unwind": "$account.roles"
    },
    {
        "$lookup": {
            "from": "role",
            "localField": "account.roles",
            "foreignField": "_id",
            "as": "roles"
        }
    },
    {
        "$unwind": "$roles"
    },
    {
        "$group": {
            "_id": "$_id",
            "firstName": {
                "$first": "$firstName"
            },
            "lastName": {
                "$first": "$lastName"
            },
            "birthDate": {
                "$first": "$birthDate"
            },
            "gender": {
                "$first": "$gender"
            },
            "email": {
                "$first": "$account.email"
            },
            "userName": {
                "$first": "$account.userName"
            },
            "functions": {
                "$first": "$account.functions"
            },
            "roles": {
                "$push": "$roles"
            }
        }
    }
])