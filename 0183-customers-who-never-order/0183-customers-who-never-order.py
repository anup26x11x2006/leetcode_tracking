import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    merge = pd.merge(customers, orders, left_on='id', right_on='customerId', how='left')
    result = merge[merge['id_y'].isna()]
    return pd.DataFrame({'Customers':result['name']})