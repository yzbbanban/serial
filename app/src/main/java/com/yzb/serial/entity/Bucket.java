package com.yzb.serial.entity;


public class Bucket {
    private Integer id;
    private String idName;
    private String explain;
    private String name;
    private Long updateTime;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", idName=" + idName +
                ", explain='" + explain + '\'' +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
