package expression;

class LinkList
{
    private LinkCh first;

    public LinkList()
    {
        first = null;
    }
    
    public LinkCh peakFirst()
    {
        return first;
    }

    public void insertFirst(char inCh)
    {
        if (!this.isEmpty())
        {
            LinkCh newLink = new LinkCh(inCh, first);
            first = newLink;
        }
        else
        {
            LinkCh newLink = new LinkCh(inCh, null);
            first = newLink;
        }
    }
    
    public void insertFirst(int inNum)
    {
        if (!this.isEmpty())
        {
            LinkCh newLink = new LinkCh(inNum, first);
            first = newLink;
        }
        else
        {
            LinkCh newLink = new LinkCh(inNum, null);
            first = newLink;
        }        
    }

    public LinkCh popFirst()
    {
        if (!this.isEmpty())
        {
            LinkCh temp = first;
            first = first.getNext();
            return temp;
        }
        else
            return null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }
    
    public boolean isLetter()
    {
        return first.getType();
    }
}
