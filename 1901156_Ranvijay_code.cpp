#include <bits/stdc++.h>
using namespace std;
int total=0;
int find(int array[][2],int m,int x,int y)
{
	if(x==y)
	return 0;
	for(int i=0;i<m;i++)
	{
			if(array[i][0]==x && array[i][1]==y)
			 return 1;
			if(array[i][0]==y && array[i][1]==x)
			 return 1;
	}
	return 0;
}
void print(int array[][2],int n,int b[],int ind)
{
	int i,flag=0;
	for(i=0;i<ind-1;i++)
	{
		if(find(array,n,b[i],b[i+1]))
		 flag=1;
		 else
		 {
		 	flag=0;
		 	break;
		 }
	}
	if(flag==1)
	{
	for(i=0;i<ind;i++)
	{
		cout<<b[i];
	}
	total++;
	cout<<"\n";
   }
}
int findx(int a[],int ind,int i)
{
	for(int j=0;j<ind;j++)
		{
			if(a[j]==i)
			return 0;
		}
	return 1;
}
int* endsem(int array[][2],int m,int n,int u,int x,int b[],int ind)
{
	int flag=0;
	for(int i=0;i<m;i++)
	{
		if(find(a,n,x,i)&&findx(b,ind,i))
		{
			b[ind]=i;
			ind++;
			endsem(a,m,n,u,i,b,ind);
		}
		if(find(a,n,u,x)&&flag==0)
		{
			print(a,n,b,ind);
			flag++;
		}
	}
}
int main()
{
	int m,n;
	cin>>m;
	cin>>n;
	int array[m][2];
	int b[m+2];

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<2;j++)
		{
			cin>>array[i][j];
		}
	}
	for(int i=0;i<m;i++)
	{
	    b[0]=i;
		endsem(a,m,n,i,i,b,1);
	}
	cout<<"\nTotal sequences are :"<<total<<endl;
}
