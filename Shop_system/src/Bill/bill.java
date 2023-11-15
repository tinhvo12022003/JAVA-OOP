/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import Customer.Customer;
import Customer.Date;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class bill {
    private String ma_hd;
    private int tong_HD; //tinh tien tu file detail_bill.txt
    private ArrayList<detail_bill> dt_bill;
    private Customer customer;
    
    public bill(){
        this.ma_hd = new String("");
        this.tong_HD = 0;
        this.dt_bill = new ArrayList<>();
        this.customer = new Customer();
    }
    
    public bill(String ma_hd, int tong_tien, ArrayList<detail_bill> dt_bill, Customer customer){
        this.ma_hd = new String(ma_hd);
        this.tong_HD = tong_tien;
        this.dt_bill = new ArrayList<>(dt_bill);
        this.customer = new Customer(customer);
    }
    
    public bill(bill b){
        this.ma_hd = new String(b.ma_hd);
        this.tong_HD = b.tong_HD;
        this.dt_bill = new ArrayList<detail_bill>(b.dt_bill);
        this.customer = new Customer(b.customer);
    }
    
    public void setMa_hd(String ma_hd){
        this.ma_hd = new String(ma_hd);
    }
    
    public String getMa_hd(){
        return new String(new bill(this).ma_hd);
    }
    
    public void setTong_hd(int tong_hd){
        this.tong_HD = tong_hd;
    }
    
    public int getTong_hd(){
        return new bill(this).tong_HD;
    }
    
    public void setDetail_bill(ArrayList<detail_bill> dt_bill){
        this.dt_bill = new ArrayList<detail_bill>(dt_bill);
    }
    
    public ArrayList<detail_bill> getDetail_bill(){
        return new ArrayList<detail_bill>(new bill(this).dt_bill);
    }
    
    public void setCustomer(Customer customer){
        this.customer = new Customer(customer);
    }
    
    public Customer getCustomer(){
        return new Customer(new bill(this).customer);
    }
    
    
}
