#include <bits/stdc++.h>
using namespace std;
class Node
{
public:
    int data;
    Node *next;
    Node *prev;

    Node(int d)
    {
        data = d;
        next = NULL;
        prev = NULL;
    }
};
Node *newNode(int x)
{
    Node *node = new Node(x);
    return node;
}
Node *front = NULL;
Node *rear = NULL;
int Size = 0;
void insertFront(int x)
{
    Node *node = newNode(x);
    if (front == NULL)
    {
        front = rear = node;
    }
    else
    {
        node->next = front;
        front->prev = node;
        front = node;
    }
    Size++;
}
void insertEnd(int x)
{
    Node *node = newNode(x);
    if (rear == NULL)
    {
        front = rear = node;
    }
    else
    {
        node->prev = rear;
        rear->next = node;
        rear = node;
    }
    Size++;
}
void deleteFront()
{
    if (front == NULL)
    {
        return;
    }
    if (front == rear)
    {
        front = rear = NULL;
    }
    else
    {
        Node *temp = front;
        front = front->next;
        front->prev = NULL;
        delete (temp);
    }
    Size--;
}
void deleteEnd()
{
    if (rear == NULL)
    {
        return;
    }
    if (front == rear)
    {
        front = rear = NULL;
    }
    else
    {
        Node *temp = rear;
        rear = rear->prev;
        rear->next = NULL;
        delete (temp);
    }
    Size--;
}
int getFront()
{
    if (front != NULL)
    {
        return front->data;
    }
    return -1;
}
int getEnd()
{
    if (rear != NULL)
    {
        return rear->data;
    }
    return -1;
}
int size()
{
    return Size;
}
bool isEmpty()
{
    if (front == NULL)
    {
        return true;
    }
    return false;
}
void erase()
{
    rear = NULL;
    while (front != NULL)
    {
        Node *temp = front;
        front->prev = NULL;
        front = front->next;
        delete (temp);
    }
    Size = 0;
}
int main()
{

    insertFront(1);
    insertEnd(10);
    insertEnd(2);
    insertFront(20);
    cout << getFront() << endl;
    cout << getEnd() << endl;
    deleteEnd();
    cout << getEnd() << endl;
    deleteFront();
    cout << getFront() << endl;
    cout << size() << endl;
    if (isEmpty())
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }
    erase();
    if (isEmpty())
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }

    return 0;
}