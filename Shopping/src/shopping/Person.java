/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import java.util.*;

/**
 *
 * @author hp
 */
public class Person {
    Scanner scanner = new Scanner(System.in);
    
    private String last_name;
    private String first_name;
    private Date date;
    private DiaChi diachi;    
    
    protected Person(){
        last_name = new String("");
        first_name = new String("");
        date = new Date();
        diachi = new DiaChi();
    }
    
    protected Person(String last_name, String first_name, Date date, DiaChi dc){
        this.first_name = new String(first_name);
        this.last_name = new String(last_name);
        this.date = new Date(date);
        this.diachi = new DiaChi(dc);
    }
    
    protected Person(Person p){
        this.first_name = new String(p.first_name);
        this.last_name = new String(p.last_name);
        this.date = new Date(p.date);
        this.diachi = new DiaChi(p.diachi);
    }
    
    protected Person(Object obj){
        Person p = new Person();
        if(obj instanceof Person){
            p = new Person(obj);
        }
        this.setFirstName(new String(p.first_name));
        this.setLastName(new String(p.last_name));
        this.setDate(new Date(p.date));
        this.setDiaChi(new DiaChi(p.diachi));
        
    }
    
    protected void setLastName(String lastName){
        this.last_name = new String(lastName);
    }
    
    protected void setFirstName(String firstName){
        this.first_name = new String(firstName);
    }
    
    public String getFirstName(){
        return new String(new Person(this).first_name);
    }
    
    public String getLasttName(){
        return new String(new Person(this).last_name);
    }
    
    public void setDate(Date date){
        this.date = new Date(date);
    }
    
    public void setDiaChi(DiaChi dc){
        this.diachi = new DiaChi(dc);
    }
    
    public Date getDate(){
        return new Date(this.date);
    }
    
    public DiaChi getDiaChi(){
        return new DiaChi(this.diachi);
    }
    
    
    protected void NhapThongTin(){
         boolean check = false;
         while(!check){
             try {
                 System.out.print("Nhap ho: ");
                 this.setLastName(new String(scanner.nextLine()));
                 System.out.print("Nhap ten: ");
                 this.setFirstName(new String(scanner.nextLine()));
                 
                 System.out.print("Nhap vao ngay/thang/nam sinh: ");
                 Date d = new Date();
                 d.Nhap();
                 this.setDate(d);
                 
                 System.out.print("Nhap vao dia chi: ");
                 DiaChi dc = new DiaChi();
                 dc.NhapDC();
                 this.setDiaChi(dc);

             }catch (Exception e){
                 System.out.println(e.getMessage());
             }
         }
    }
    
    @Override
    public String toString(){
        return "Ho va ten: " + this.getLasttName() + " " + this.getFirstName() +"\nNgay sinh: " +this.getDate() + "\nDia chi: " + this.getDiaChi();
    }
}
