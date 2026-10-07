class Solution {
public:
    int getValue(const char & c)
    {
        switch( c )
            {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            };
    }

    int romanToInt(string s) 
    {
        int value = 0;
        int lastElement = s.size() - 1;
        for( int i = 0; i < lastElement; ++i )
        {
            char currentCharacter = s[i];
            char nextCharacter = '\0';
            if( i <= lastElement )
            {
                nextCharacter = s[i + 1];
            }

            int currentValue = getValue(currentCharacter);
            int nextValue = getValue(nextCharacter);

            if( nextValue == 0 || nextValue <= currentValue )
            {
                value += currentValue;
            }
            else
            {
                value -= currentValue;
            }
        }
        
        value += getValue(s[lastElement]);
        return value;
    }
};