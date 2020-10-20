class MyHashSet {
    static int p;
    static int m;
    static int[] s;
    static Integer myInf;
    /** Initialize your data structure here. */
    public MyHashSet() {
        p=1000001;
        m=10000;
        myInf = Integer.MAX_VALUE;
        s = new int[m];
        Arrays.fill(s,0,m,myInf);
    }
    
    public int h(int k, int i) {
        return (h1(k) + i*h2(k))%m;
    }
    public int h1(int k) {
        int a=501,b=1039;
        return ((a*k+b)%p)%m;
    }
    public int h2(int k) {
        int c=51,d=52679;
        return ((c*k+d)%p)%m;
    }
    public void add(int key) {
        int i=0;
        while (i<m) {
            int j=h(key,i);
            if (s[j]==myInf || s[j]==key) {
                s[j]=key;
                break;
            } else {
                i++;
            }
        }
    }
    
    public void remove(int key) {
        int i=0;
        while (i<m) {
            int j=h(key,i);
            if (s[j]==key) {
                s[j]=myInf;
                break;
            } else {
                i++;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i=0;
        while (i<m) {
            int j=h(key,i);
            if (s[j]==key) {
                return true;
            }
            i++;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
