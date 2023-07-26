JAVAC = javac
INPUT_SCENARIO_FILENAME = scenario.txt
INPUT_SCENARIO_DIR = $(CURDIR)/resource/scenario/
INPUT_SCENARIO = $(INPUT_SCENARIO_DIR)$(INPUT_SCENARIO_FILENAME)

ERR_TEST_SCENARIO_FILENAME = err_nodata.txt
ERR_TEST_SCENARIO_DIR = $(CURDIR)/resource/err_scenario/
ERR_TEST_SCENARIO = $(ERR_TEST_SCENARIO_DIR)$(ERR_TEST_SCENARIO_FILENAME)

all :
	@$(MAKE) compile
	@$(MAKE) run

compile :
	find * -name "*.java" > sources.txt
	javac @sources.txt

clean :
	find * -name "*.class" -delete
	rm -f sources.txt
	rm -f simulation.txt

run :
	java kr.ft.avaj.simulator.main $(INPUT_SCENARIO)

err :
	@$(MAKE) compile
	java kr.ft.avaj.simulator.main $(ERR_TEST_SCENARIO)

land :
	@$(MAKE) compile
	java kr.ft.avaj.simulator.main $(INPUT_SCENARIO_DIR)/land_test.txt

re :
	@$(MAKE) clean
	@$(MAKE) all