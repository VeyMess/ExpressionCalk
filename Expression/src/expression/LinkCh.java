package expression;

class LinkCh
{
    private Object ch;
    private LinkCh next;
    private boolean letter;

    public LinkCh(Object inCh, LinkCh list)
    {
        if (inCh.getClass().getSimpleName().equals("Character"))
        {
            ch = (Character) inCh;
            next = list;
            letter = true;
        }
        else if (inCh.getClass().getSimpleName().equals("Double"))
        {
            ch = (Double) inCh;
            next = list;
            letter = false;
        }
    }

    public char getCh()
    {
        return (Character) ch;
    }

    public double getNum()
    {
        return (Double) ch;
    }

    public void setCh(Object inCh)
    {
        ch = inCh;
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
