SOURCE_VERSION = 1.7
JFLAGS ?= -g:source,lines,vars -encoding utf8
TOUCH_DIR = .touch


all: compile jar eclipse src

# Sources
SRC = ui.alert ui.graphical
src: $(SRC)
ui.alert::     aeten.core
ui.graphical::

# COTS
COTS = aeten.core jcip.annotations slf4j
cots: $(COTS)
aeten.core::       jcip.annotations slf4j
jcip.annotations::
slf4j::

clean:
	$(RM) -rf $(BUILD_DIR) $(DIST_DIR) $(GENERATED_DIR) $(TOUCH_DIR)

SRC_DIRS = src/
MODULES = $(SRC) $(COTS)
include Java-make/java.mk

