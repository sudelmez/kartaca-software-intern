.PHONY: react_app
react_app:
	docker-compose up -d react_app

.PHONY: run_docker_compose
run_docker_compose:
	docker-compose up -d 

.PHONY: build_docker_compose
build_docker_compose:
	docker compose up --build 

.PHONY: run_py
run_py:
	docker-compose run python_script_input

.PHONY: create_network
create_network:
	docker network create dataservice

