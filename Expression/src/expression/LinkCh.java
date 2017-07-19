package expression;

class LinkCh
{
    private char ch;
    private LinkCh next;
    private int numb;
    private boolean letter;

    public LinkCh(char inCh, LinkCh list)
    {
        ch = inCh;
        next = list;
        letter=true;
    }

    public LinkCh(int inNum, LinkCh list)
    {
        numb = inNum;
        next = list;
        letter=false;
    }

    public char getCh()
    {
        return ch;
    }
    
    public int getNum()
    {
        return numb;
    }

    public void setCh(char inCh)
    {
        ch = inCh;
    }
    
    public void setNum(int inNum)
    {
        numb = inNum;
    }

    public LinkCh getNext()
    {
        return next;
    }

    public void setNext(LinkCh inLi)
    {
        next = inLi;
    }
    
    public boolean getType()
    {
        return letter;
    }
}
