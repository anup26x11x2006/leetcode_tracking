with cte as (select d.name as "Name", max(e.salary) as "MaxSalary"
  from Employee e
  join Department d
  on e.departmentId = d.id
  group by d.name)

select d.name as "Department", e.name as "Employee", e.salary
  from Employee e
  join Department d
  on e.departmentId = d.id
  where e.salary = (select cte.MaxSalary from cte where d.name = cte.Name)