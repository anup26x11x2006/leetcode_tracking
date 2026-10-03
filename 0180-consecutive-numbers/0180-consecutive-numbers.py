import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:
    
    logs['var'] = logs.num.rolling(window=3).var()

    return pd.DataFrame(data = {'ConsecutiveNums' : logs.query('var == 0').num.unique()})