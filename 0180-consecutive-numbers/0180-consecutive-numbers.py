import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:

    ids = logs['num'].to_list()
    out = set()
    for id in range(1,len(ids)-1):
        if ids[id] == ids[id-1] and ids[id+1] == ids[id]:
            out.add(ids[id])
    out = list(out)
    return pd.DataFrame({'ConsecutiveNums':out})
    