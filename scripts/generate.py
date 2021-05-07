import sys
import json
from jinja2 import Template

GRAMMAR = json.load(open("grammar.json"))

template = Template(open("grammar.jinja").read())
output = template.render(grammar=GRAMMAR)

print(output)
