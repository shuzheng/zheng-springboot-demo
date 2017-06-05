package com.zheng.domain;

public class Records {
  private Long id;
  private Long productid;
  private Long count;
  private Long userid;
  private java.sql.Timestamp ctime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductid() {
    return productid;
  }

  public void setProductid(Long productid) {
    this.productid = productid;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public java.sql.Timestamp getCtime() {
    return ctime;
  }

  public void setCtime(java.sql.Timestamp ctime) {
    this.ctime = ctime;
  }
}
