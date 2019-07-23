public class List{
	private int[] array;
	private int size;
	public List(){//构造方法
		array=new int[2];
		size=0;
	}
	//尾插
	public void pushback(int element){
		ensureCapacity();
		array[size++]=element;
	}
	//头插
	public void pushfront(int element){
		ensureCapacity();
		for(int i=size;i>=1;i--){
			array[i]=array[i-1];
		}
		array[0]=element;
		size++;
	}
	//找下标插入
	public void insert(int index,int element){
		if(index<0||index>size){
			System.err.println("下标错误");
			return;
		}
		ensureCapacity();
		for(int i=size;i>=index+1;i--){
			array[i]=array[i-1];
		}
		array[index]=element;
		size++;
	}
	//尾删
	public void popBack(){
		if(size<=0){
		System.err.println("顺序表为空");
		return;
		}
		array[--size]=0;
	}
	//头删
	public void popFront(){
		for(int i=1;i<=size-1;i++){
			array[i-1]=array[i];
		}
		array[--size]=0;
	}
	//按照下标删除
	public void delete(int index){
		for(int i=index+1;i<size;i++){
			array[i-1]=array[i];
		}
		array[--size]=0;
	}
	//保证容量足够，否则扩容
	private void ensureCapacity(){
		if(size<array.length){
			return;
		}
		int newCapacity=array.length*2;
		int[] NewArray=new int[newCapacity];
		for(int i=0;i<size;i++){
			NewArray[i]=array[i];
		}
		array=NewArray;
	}
	//打印
	public void print(){
		for(int i=0;i<size;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		List list=new List();
		list.pushback(1);//1
		list.pushback(2);//1 2
		list.pushback(3);//1 2 3
		list.pushfront(10);//10 1 2 3 
		list.pushfront(20);//20 10 1 2 3
		list.pushfront(30);//30 20 10 1 2 3
		list.insert(2,100);//30 20 100 10 1 2 3
		list.print();//
		list.popBack();//30 20 100 10 1 2
		list.popFront();//20 100 10 1 2
		list.print();
		list.delete(1);//20 10 1 2
		list.print();
	}
}