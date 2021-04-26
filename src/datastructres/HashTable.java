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
public class HashTable
{
    private Entry[] entries;
    private int size=0;
    
    public HashTable()
    {
        entries=new Entry[11];
        
    }
    
    private int hash(String key)
    {
        return (key.hashCode() & 0x7fffffff)%entries.length;
    }
    
    public String get(String key)
    {
        int h=hash(key);
        
        for(Entry e=entries[h]; e!=null; e=e.nextEntry)
        {
            if(e.key.equals(key)) return e.value;
        }
        
        return null;
    }
    
    public String remove(String key)
    {
        int h=hash(key);
        System.out.println(h+" for:"+key);
        if(entries[h].key.equals(key))
        {
            Entry e=entries[h];
            entries[h]=entries[h].nextEntry;
            --size;
            return e.value;
        }
        for(Entry e=entries[h]; e!=null; e=e.nextEntry)
        {
            if(e.nextEntry.key.equals(key))
            {
                Entry temp=e.nextEntry;
                e.nextEntry=e.nextEntry.nextEntry;
                --size;
                return temp.value;
            }
        }
        
        return null;
    }
    public String put(String key,String value)
    {
        int h=hash(key);
        System.out.println(h+" for:"+key);
        if(entries[h]==null)
        {
            entries[h]=new Entry(key,value,entries[h]);
            ++size;
            return value;
        }
        for(Entry e=entries[h]; e!=null; e=e.nextEntry)
        {
            if(e.key.equals(key))
            {
                String temp=e.value;
                e.value=value;
                
                return temp;
            }
            
            else if(e.nextEntry==null)
            {
                e.nextEntry=new Entry(key,value,e.nextEntry);
                ++size;
                return value;
            }
        }
        
        return null;
    }
    public  int size()
    {
        return size;
    }
    public class Entry
    {
        String key;
        String value;
        Entry nextEntry;
        
        public Entry(String key,String value,Entry nextEntry)
        {
            this.key=key;
            this.value=value;
            this.nextEntry=nextEntry;
        }
    }
    @Override
    public String toString()
    {
        if(size()==0) return "";
        StringBuffer buffer=new StringBuffer();
        
        for(int i=0; i<entries.length; i++)
        {
            for(Entry e=entries[i]; e!=null; e=e.nextEntry)
            {
                buffer.append(e.key+","+e.value+"\n");
            }
        }
        
        return buffer+"";
    }
}
