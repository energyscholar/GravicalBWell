package com.gravical.bwell.models;
// Generated 19-Feb-2013 01:44:26 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Annotations generated by hbm2java
 */
public class Annotations  implements java.io.Serializable {


     private int annotationId;
     private String annotationText;
     private Date annotationTs;
     private Integer bwellSessionId;

    public Annotations() {
    }

	
    public Annotations(int annotationId) {
        this.annotationId = annotationId;
    }
    public Annotations(int annotationId, String annotationText, Date annotationTs, Integer bwellSessionId) {
       this.annotationId = annotationId;
       this.annotationText = annotationText;
       this.annotationTs = annotationTs;
       this.bwellSessionId = bwellSessionId;
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
    public Integer getBwellSessionId() {
        return this.bwellSessionId;
    }
    
    public void setBwellSessionId(Integer bwellSessionId) {
        this.bwellSessionId = bwellSessionId;
    }




}


