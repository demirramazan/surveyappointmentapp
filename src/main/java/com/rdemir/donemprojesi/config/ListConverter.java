package com.rdemir.donemprojesi.config;


import com.rdemir.donemprojesi.entities.BaseEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Named
@FacesConverter("listConverter")
public class ListConverter implements Converter {

    private static final String key = "com.rdemir.donemprojesi.config.ListConverter";
    private static final String empty = "";

    private Map<String, Object> getViewMap(FacesContext context) {
        Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        @SuppressWarnings({"unchecked", "rawtypes"})
        Map<String, Object> idMap = (Map) viewMap.get(key);
        if (idMap == null) {
            idMap = new HashMap<>();
            viewMap.put(key, idMap);
        }
        return idMap;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent c, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value + c.getClientId());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent c, Object value) {
        if (value == null) {
            return empty;
        }
        String stringValue;
        if (value instanceof BaseEntity) {
            stringValue = ((BaseEntity) value).getId().toString();
            try {
                Class methodParams[] = new Class[0];
                if (value instanceof BaseEntity) {
                    Method getName = value.getClass().getDeclaredMethod("getName", methodParams);
                    if (getName != null) {
                        stringValue = (String) getName.invoke(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            stringValue = value.toString();
        }

        getViewMap(context).put(stringValue + c.getClientId(), value);
        return stringValue;
    }
}