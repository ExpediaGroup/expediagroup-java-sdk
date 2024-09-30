import * as fs from 'node:fs'
import { Edit, Lang, NapiConfig, parse, SgNode } from '@ast-grep/napi'
import { PathOrFileDescriptor } from 'fs'
import * as yaml from 'yaml'

function process (filePath: PathOrFileDescriptor): void {
  const source = fs.readFileSync(filePath, 'utf-8')
  const ast = parse(Lang.Kotlin, source)
  const root = ast.root()

  const edits = [book].flatMap((func) => func(root))
  const newSource = root.commitEdits(edits)
  fs.writeFileSync(filePath, newSource)
}

function readRule (ruleName: string): NapiConfig {
  const rule = fs.readFileSync(`./rules/payment-sessions-links/${ruleName}.yaml`, 'utf-8')
  return yaml.parse(rule)
}

function book (root: SgNode): Edit[] {
    const config = readRule('book')

    return root.findAll(config).map((node) => {
        return node.replace("PostItineraryOperationLink")
    })
}

export { process as processPaymentSessionsLinks }
