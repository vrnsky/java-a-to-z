select car.name, g.type, e.type, t.type from cars as car inner join gearbox as g on
car.gearbox_id = g.id inner join engine as e on car.engine_id = e.id inner join
transmission as t on car.transmission_id = t.id;