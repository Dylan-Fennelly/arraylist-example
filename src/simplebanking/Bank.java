package simplebanking;

import java.util.ArrayList;

public class Bank
{
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name)
    {
        this.name = name;
        this.branches = new ArrayList<>();
    }
    public String getName()
    {
        return this.name;
    }
    public boolean addBranch(Branch newBranch)
    {
        if(findBranch(newBranch.getName())==true)
        {
            System.out.println("Branch already exits");
            return false;
        }
        branches.add(newBranch);
        return true;
    }

    private boolean findBranch(String name)
    {
        for(int i = 0; i<this.branches.size();i++)
        {
            Branch branch = this.branches.get(i);
            if(branch.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
}
