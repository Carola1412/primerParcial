package com.example.xmen.config;

import com.example.xmen.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    /*Esta clase se encarga de hacer las revisiones*/

    /*Esta es la funcion para revisar entidades*/
    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
    }/*Con esto tomamos el objeto y lo casteamos como una revision*/
}
