import java.util.*;
import java.io.*;
class cque_ArrayList
{
private int size, front, rear;
private ArrayList<Integer> queue = new ArrayList<Integer>();
cque_ArrayList(int size)
{
	this.size = size;
	this.front = this.rear = -1;
}
public void insert(int data)
{
	if((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1)))
	{
		System.out.print("Queue is Full");
	}
	else if(front == -1)
	{
		front = 0;
		rear = 0;
		queue.add(rear, data);
	}
	else if(rear == size - 1 && front != 0)
	{
		rear = 0;
		queue.set(rear, data);
	}
	else
	{
		rear = (rear + 1);
		if(front <= rear)
		{
			queue.add(rear, data);
		}
		else
		{
			queue.set(rear, data);
		}
	}
}
public int remove()
{
	int temp;
	if(front == -1)
	{
		System.out.print("Queue is Empty");
		return -1;
	}
	temp = queue.get(front);
	if(front == rear)
	{
		front = -1;
		rear = -1;
	}

	else if(front == size - 1)
	{
		front = 0;
	}
	else
	{
		front = front + 1;
	}
	return temp;
}
public void display()
{
	if(front == -1)
	{
		System.out.print("Queue is Empty");
		return;
	}
	System.out.print("Elements in the circular queue are: ");
	if(rear >= front)
	{
		for(int i = front; i <= rear; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}
	else
	{
		for(int i = front; i < size; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}
		for(int i = 0; i <= rear; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}
}
void isFull()
{
    if((rear+1)%size==front)
    {
        System.out.println("Queue is full.");
    }
    else
    {
        System.out.println("Queue is empty.");
    }
}
void isEmpty()
{
    if(front==-1&&rear==-1)
    {
        System.out.println("Queue is empty.");
    }
    else
    {
        System.err.println("Queue is not empty.");
    }
}
public static void main(String args[]) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the cqueue:");
        int n = sc.nextInt();
        cque_ArrayList obj = new cque_ArrayList(n);
        int choice=0;
        while (choice != 6) 
        {
            System.out.println("Press 1: Insert an element");
            System.out.println("Press 2: Delete an element");
            System.out.println("Press 3: Display the element");
            // System.out.println("Press 4: Check wheater the queue is empty");
            // System.out.println("Press 5: Check wheter the queue is full");
            System.out.println("Press 4: Terminate the program");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the element which is to be inserted:");
                    int x = sc.nextInt();
                    obj.insert(x);
                    break;
                case 2:
                    int k=obj.remove();
                    System.out.println(k+" has been removed.");
                    break;
                case 3:
                    obj.display();
                    break;
                // case 4:
                //     obj.isEmpty();
                //     break;
                // case 5:
                //     obj.isFull();
                //     break;
                case 4:
                    System.out.println("Program Terminates.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }
        sc.close();
    }
}
// public static void main(String[] args)
// {
// 	CircularQueue q = new CircularQueue(5);
	
// 	q.enQueue(14);
// 	q.enQueue(22);
// 	q.enQueue(13);
// 	q.enQueue(-6);
	
// 	q.displayQueue();

// 	int x = q.deQueue();
// 	if(x != -1)
// 	{
// 		System.out.print("Deleted value = ");
// 		System.out.println(x);
// 	}

// 	x = q.deQueue();
// 	if(x != -1)
// 	{
// 		System.out.print("Deleted value = ");
// 		System.out.println(x);
// 	}

// 	q.displayQueue();
	
// 	q.enQueue(9);
// 	q.enQueue(20);
// 	q.enQueue(5);
	
// 	q.displayQueue();
	
// 	q.enQueue(20);
// }
// }