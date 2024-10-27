package org.haiyang.orderdemo.po;

import lombok.Data;

@Data

public class Order {

  private int id;
  private int userId;
  private int productsId;
  private int quantity;
  

}
