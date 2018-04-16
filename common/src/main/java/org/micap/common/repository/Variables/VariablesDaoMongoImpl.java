/**
 * The VariablesDaoMongoImpl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :4/04/2018
 */
package org.micap.common.repository.Variables;

import com.mongodb.async.client.MongoCollection;
import org.bson.Document;
import org.micap.common.entity.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.micap.common.CommonApplication.VARIABLES;

public class VariablesDaoMongoImpl implements VariablesDao{


    @Override
    public void update_variables() {
        /*COLLECTION_VARIABLES.find().into(new ArrayList<Document>(),
                (data,t)->{
                    data.forEach(e->{
                        Map f= (Map) data;
                        System.out.println(f);
                    });
                    VARIABLES.put("variables",data);
                }
        );*/
    }
}
