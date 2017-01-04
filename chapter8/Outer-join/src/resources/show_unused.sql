
-- show unused details.
select g.type from gearbox as g
left outer join cars as car on g.id = car.gearbox_id where car.gearbox_id is null

union

select e.type from engine as e
left outer join cars as car on e.id = car.engine_id where car.engine_id is null

union

select t.type from transmission as t
left outer join cars as car on t.id = car.transmission_id where car.transmission_id is null;