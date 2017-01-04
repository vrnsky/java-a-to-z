select i.id, i.name, i.description, category.category, status.status
from items as i
inner join item_category as category
on i.category_id = category.id
inner join item_status as status
on i.status = status.id
where i.name like '%fix%' or status.status like '%OPEN%';