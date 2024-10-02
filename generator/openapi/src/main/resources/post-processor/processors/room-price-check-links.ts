import * as fs from 'node:fs'
import { Edit, Lang, NapiConfig, parse, SgNode } from '@ast-grep/napi'
import { PathOrFileDescriptor } from 'fs'
import * as yaml from 'yaml'

function process (filePath: PathOrFileDescriptor): void {
  const source = fs.readFileSync(filePath, 'utf-8')
  const ast = parse(Lang.Kotlin, source)
  const root = ast.root()

  const edits = [book, commit, paymentSession, additionalRates].flatMap((func) => func(root))
  const newSource = root.commitEdits(edits)
  fs.writeFileSync(filePath, newSource)
}

function readRule (ruleName: string): NapiConfig {
  const rule = fs.readFileSync(`./rules/room-price-check-links/${ruleName}.yaml`, 'utf-8')
  return yaml.parse(rule)
}

function book (root: SgNode): Edit[] {
  const config = readRule('book')

  return root.findAll(config).map((node) => {
    return node.replace("PostItineraryOperationLink")
  })
}

function commit (root: SgNode): Edit[] {
    const config = readRule('commit')

    return root.findAll(config).map((node) => {
        return node.replace("CommitChangeOperationLink")
    })
}

function paymentSession (root: SgNode): Edit[] {
    const config = readRule('payment-session')

    return root.findAll(config).map((node) => {
        return node.replace("PostPaymentSessionsOperationLink")
    })
}

function additionalRates (root: SgNode): Edit[] {
    const config = readRule('additional-rates')

    return root.findAll(config).map((node) => {
        return node.replace("GetAdditionalAvailabilityOperationLink")
    })
}

export { process as processRoomPriceCheckLinks }