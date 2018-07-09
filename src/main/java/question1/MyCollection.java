package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
        private int currCapacity;
        private int currCount;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
                currCapacity = arraySize;
	}
        public MyCollection(int arraySize, int[] Array){
            
        }

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
                for(int i=0;i<currCount;i++)
                {
                    if(numArray[i] == searchingNum)
                        return i;
                }
		return -1;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
               
              if(search(numberToAdd)==-1)
                {
                    if(currCount<currCapacity)
                    {
                        numArray[currCount] = numberToAdd;
                        currCount++;
                    }
                    else
                    {
                        doubleCapacity();
//                        System.out.println(currCount);
                        
                        numArray[currCount] = numberToAdd;
//                        System.out.println(currCapacity);
                        currCount++;
                    }
//                    System.out.println(currCount);
//                    System.out.println(currCapacity);
                    return true;
                }
                  
                
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
                currCapacity*=2;
                int[] newArray = new int[currCapacity];
                System.arraycopy(numArray, 0, newArray, 0, currCount);
                numArray = newArray;
                
		
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
                int pos = search(numberToRemove);
                if(pos != -1){
                    int i = 0;
                    for(i=pos;i<currCount;i++)
                    {
                        numArray[i] = numArray[i+1];
                    }
                    numArray[i-1] = 0;
                    currCount--;
                    return true;
                }
                
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return currCount;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
                int[] array = new int[currCapacity];
                for(int i=0;i<currCount;i++)
                {
                    array[i] = numArray[(i+n)%currCount];
                }
                numArray = array;
		return numArray;
	}
        
        public String toString() {
            String str = "{";
            int t = 0; 
            for(int a: numArray)
            {
                t++;
                if(a != 0)
                {
                    
                    str+= String.valueOf(a);
                    if(t != currCount)
                        str+=",";
                }
            }
            str+="}";
            return str;
        }

   

}
