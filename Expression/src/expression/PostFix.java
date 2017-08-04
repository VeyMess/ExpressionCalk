package expression;

class PostFix
{
    private String finale = "";
    private boolean isGood = true;

    public PostFix(String inExp)
    {
        String str = "";
        LinkList temp = new LinkList();
        boolean lastscob = false;
        boolean dotCheck = false;
        for (int i = 0; i < inExp.length(); i++)
        {
            char check = inExp.charAt(i);
            if (Character.isDigit(check) || check == '.')
            {
                if (lastscob == true || check == '.' && dotCheck == true)
                {
                    isGood = false;
                    break;
                }
                if (check == '.')
                {
                    dotCheck = true;
                    if (str.isEmpty())
                        str += '0';
                }
                if(check=='0' && str.isEmpty())
                    continue;
                str += check;
            }
            else if (check == '+' || check == '-' || check == '*' || check == '/')
            {
                if (str.isEmpty() && lastscob == false || i == inExp.length() - 1)
                {
                    isGood = false;
                    break;
                }
                else
                {
                    if (finale.isEmpty() ||
                        !Character.isDigit(finale.charAt(finale.length() - 1)) &&
                        !(finale.charAt(finale.length() - 1) == '.'))
                        finale += str;
                    else
                        finale += "," + str;
                    str = "";
                    if (temp.isEmpty())
                    {
                        temp.insertFirst(check);
                    }
                    else
                    {
                        if (temp.peakFirst().getCh() != '(' && this.firstLesPrior(check, temp.peakFirst().getCh()))
                        {
                            finale += temp.popFirst().getCh();
                            temp.insertFirst(check);
                        }
                        else
                            temp.insertFirst(check);
                    }
                }
                lastscob = false;
                dotCheck = false;
            }
            else if (check == '(')
            {
                if (!str.isEmpty())
                {
                    isGood = false;
                    break;
                }
                else
                {
                    temp.insertFirst(check);
                }
            }
            else if (check == ')')
            {
                if (str.isEmpty() && lastscob == false)
                {
                    isGood = false;
                    break;
                }
                else
                {
                    if (finale.isEmpty() || temp.peakFirst().getCh() == '(')
                    {
                        isGood = false;
                        break;
                    }
                    if (Character.isDigit(finale.charAt(finale.length() - 1)) ||
                        finale.charAt(finale.length() - 1) == '.')
                        finale += "," + str;
                    else
                        finale += str;
                    str = "";
                    while (temp.peakFirst().getCh() != '(')
                    {
                        finale += temp.popFirst().getCh();
                        if (temp.isEmpty())
                        {
                            isGood = false;
                            break;
                        }
                    }
                    if (!isGood)
                        break;
                    temp.popFirst();
                    if (i == inExp.length() - 1 && temp.isEmpty())
                        break;
                    lastscob = true;
                    dotCheck = false;
                }
            }

            if (i == inExp.length() - 1)
            {
                if (temp.isEmpty() || temp.peakFirst().getCh() == '(')
                {
                    isGood = false;
                    break;
                }
                if (Character.isDigit(finale.charAt(finale.length() - 1)) || finale.charAt(finale.length() - 1) == '.')
                    finale += "," + str;
                else
                    finale += str;
                while (!temp.isEmpty())
                {
                    if (temp.peakFirst().getCh() == '(')
                    {
                        isGood = false;
                        break;
                    }
                    finale += temp.popFirst().getCh();
                }
            }
        }
    }

    public String getStr()
    {
        if (isGood)
            return finale;
        else
            return null;
    }

    private boolean firstLesPrior(char in, char out)
    {
        int inCheked = 0, outCheked = 0;
        switch (in)
        {
            case '+':
            case '-':
                inCheked = 1;
                break;
            case '*':
            case '/':
                inCheked = 2;
                break;
        }

        switch (out)
        {
            case '+':
            case '-':
                outCheked = 1;
                break;
            case '*':
            case '/':
                outCheked = 2;
                break;
        }

        return (inCheked <= outCheked);
    }
}
