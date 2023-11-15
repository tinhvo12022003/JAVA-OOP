/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author hp
 */
public class Address {
    private String so_nha, xa, huyen, tinh;
    
    Address(){
        this.so_nha = new String("");
        this.xa = new String("");
        this.huyen = new String("");
        this.tinh = new String("");
    }
    
    Address(String so_nha, String xa, String huyen, String tinh){
        this.so_nha = new String(so_nha);
        this.xa = new String(xa);
        this.huyen = new String(huyen);
        this.tinh = new String(tinh);
            
    }
    
    Address(Address addr){
        this.so_nha = new String(addr.so_nha);
        this.xa = new String(addr.xa);
        this.huyen = new String(addr.huyen);
        this.tinh = new String(addr.tinh);            
    }
    
    public void setSoNha(String so_nha){
        this.so_nha = new String(so_nha);
    }
    
    public String getSoNha(){
        return new String(new Address(this).so_nha);
    }
    
    public void setXa(String xa){
        this.xa = new String(xa);
    }
    
    public String getXa(){
        return new String(new Address(this).xa);
    }
    
    public void setHuyen(String huyen){
        this.huyen = new String(huyen);
    }
    
    public String getHuyen(){
        return new String(new Address(this).huyen);
    }
    
    public void setTinh(String tinh){
        this.tinh = new String(tinh);
    }
    
    public String getTinh(){
        return new String(new Address(this).tinh);
    }
    
    @Override
    public String toString(){
        return this.getSoNha() + "\n" + this.getXa() + "\n" + this.getHuyen() +"\n" + this.getTinh();
    }
}
