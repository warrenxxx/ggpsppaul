db.user.aggregate([
    {
        "$match": {
            "_id": ObjectId("5ad9149919d2221a487d1ca1")
        }
    },
    {
        "$replaceRoot": {
            "newRoot": "$account"
        }
    },
    {
        "$unwind": "$roles"
    },
    {
        "$lookup": {
            "from": "role",
            "localField": "roles",
            "foreignField": "_id",
            "as": "roles"
        }
    },
    {
        "$unwind": "$roles"
    },
    {
        "$unwind": {
            "path": "$roles.functions",
            "preserveNullAndEmptyArrays": true
        }
    },
    {
        "$group": {
            "_id": null,
            "functions": {
                "$first": "$functions"
            },
            "roles": {
                "$push": "$roles.functions"
            }
        }
    },
    {
        "$project": {
            "items": {
                "$concatArrays": [
                    "$roles",
                    "$functions"
                ]
            }
        }
    },
    {
        "$unwind": "$items"
    },
    {
        "$unwind": "$items.crudMethods"
    },
    {
        "$project": {
            "item": {
                "$concat": [
                    "$items.entity",
                    "-",
                    "$items.crudMethods"
                ]
            }
        }
    },
    {
        "$group": {
            "_id": null,
            "functions": {
                "$push": "$item"
            }
        }
    }
])