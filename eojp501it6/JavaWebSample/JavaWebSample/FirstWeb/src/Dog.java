
import java.io.*;
public class Dog implements Serializable
{
		String dogname;
		int age;
		double weight;

		public Dog()
		{}
		public String getDogname()
		{return this.dogname;
		}
		public int getAge()
		{return this.age;
		}
		public double getWeight()
		{return this.weight;
		}
		public String getIssue()
		{
			if(weight>40)
			{
				return "�ӭD�F�I";
			}else
			{
				return "�L";
			}
		}
		public void setDogname(String s)
		{this.dogname=s;
		}
		public void setAge(int n)
		{this.age=n;
		}
		public void setWeight(double w)
		{this.weight=w;
		}
}
