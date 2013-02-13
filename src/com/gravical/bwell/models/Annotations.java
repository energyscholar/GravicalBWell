package com.gravical.bwell.models;
// Generated 13-Feb-2013 01:12:06 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Annotations generated by hbm2java
 */
public class Annotations  implements java.io.Serializable {


     private int annotationId;
     private String annotationText;
     private Date annotationTs;

    public Annotations() {
    }

	
    public Annotations(int annotationId) {
        this.annotationId = annotationId;
    }
    public Annotations(int annotationId, String annotationText, Date annotationTs) {
       this.annotationId = annotationId;
       this.annotationText = annotationText;
       this.annotationTs = annotationTs;
    }
   
    public int getAnnotationId() {
        return this.annotationId;
    }
    
    public void setAnnotationId(int annotationId) {
        this.annotationId = annotationId;
    }
    public String getAnnotationText() {
        return this.annotationText;
    }
    
    public void setAnnotationText(String annotationText) {
        this.annotationText = annotationText;
    }
    public Date getAnnotationTs() {
        return this.annotationTs;
    }
    
    public void setAnnotationTs(Date annotationTs) {
        this.annotationTs = annotationTs;
    }




}

