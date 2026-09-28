import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    joined = employee.merge(employee, left_on = 'managerId', right_on = 'id', how = 'left')
    result = joined[joined['salary_x'] > joined['salary_y']]
    result = result[['name_x']]
    result.rename(columns = {'name_x' : 'Employee'}, inplace = True)
    return result