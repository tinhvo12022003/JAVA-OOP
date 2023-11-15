/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author hp
 */
public class Person {
    private String hoten;
    private Date date;
    private Address address;
    private String phone;
    
    Person(){
        this.hoten = new String("");
        this.date = new Date();
        this.address = new Address();
        this.phone = new String("");
    }
    
    Person(String hoten, Date date, Address address, String phone){
        this.hoten = new String(hoten);
        this.date = new Date(date);
        this.address = new Address(address);
        this.phone = new String(phone);
    }
    
    Person(Person p){
        this.hoten = new String(p.hoten);
        this.date = new Date(p.date);
        this.address = new Address(p.address);
        this.phone = new String(p.phone);
    }
    
    public void setHoten(String hoten){
        this.hoten = new String(hoten);
    }
    
    public String getHoten(){
        return new String(new Person(this).hoten);
    }
    
    public void setDate(Date d){
        this.date = new Date(d);
    }
    
    public Date getDate(){
        return  new Date(new Person(this).date);
    }
    
    public void setAddress(Address addr){
        this.address = new Address(addr);
    }
    
    public Address getAddress(){
        return new Address(new Person(this).address);
    }
    
    public void setPhone(String phone){
        this.phone = new String(phone);
    }
    
    public String getPhone(){
        return new String(new Person(this).phone);
    }
}
