/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructres;

/**
 *
 * @author Badar Muneer
 */
public interface Queue<V>
{
    Object first();
    Object remove();
    void add(V key);
    int size();
    boolean isEmpty();
    
}
